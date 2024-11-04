package com.analyzer.service;

import com.analyzer.model.Feedback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@Service
public class FeedbackAiService {

    private final WebClient webClient;

    @Value("${openai.api.key}")
    private String openAiApiKey;

    public FeedbackAiService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1")
                .build();
    }

    public void analisarFeedback(Feedback feedback) {
        String descricaoOriginal = feedback.getDescricao();
        System.out.println("Analisando feedback com IA: " + descricaoOriginal);


        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", new Object[]{
                        Map.of("role", "user", "content", "Analise o seguinte feedback e classifique-o como bom, ruim ou neutro:\n\n\"" + descricaoOriginal + "\"\n\nClassificação:")
                },
                "max_tokens", 50
        );


        String result = webClient.post()
                .uri("/chat/completions")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + openAiApiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        if (result != null) {

            String classificacao = parseClassificacao(result);
            String justificativa = parseJustificativa(result);


            feedback.setDescricao(String.format(
                    "Feedback original: %s\n| Classificação da IA:  %s [analisado com IA]",
                    descricaoOriginal, classificacao, justificativa
            ));


            System.out.println("Descrição completa do feedback: " + feedback.getDescricao());
        } else {
            System.err.println("Erro: a resposta da IA é nula.");
        }
    }

    private String parseClassificacao(String jsonResponse) {
        try {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            com.fasterxml.jackson.databind.JsonNode root = mapper.readTree(jsonResponse);
            return root.path("choices").get(0).path("message").path("content").asText().trim().toLowerCase();
        } catch (Exception e) {
            System.err.println("Erro ao parsear a resposta da API: " + e.getMessage());
            return "neutro";
        }
    }

    private String parseJustificativa(String jsonResponse) {
        return parseClassificacao(jsonResponse);
    }



}
