package com.analyzer.Producer;

import com.analyzer.DTO.FeedbackDTO;
import com.analyzer.model.Feedback;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedbackProducer {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    private final String EXCHANGE_NAME = "feedback-exchange";
    private final String ROUTING_KEY = "feedback-routing-key";

    @Autowired
    public FeedbackProducer(AmqpTemplate amqpTemplate, ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.objectMapper = objectMapper;
    }

    public void enviarFeedbackParaFila(Feedback feedback) {
        try {

            FeedbackDTO feedbackDTO = new FeedbackDTO(
                    feedback.getId(),
                    feedback.getDescricao(),
                    feedback.getNota(),
                    feedback.getUsuario().getId(),
                    feedback.getData()
            );
            String feedbackJson = objectMapper.writeValueAsString(feedbackDTO);
            amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, feedbackJson);
            System.out.println("Feedback enviado para a fila: " + feedbackJson);
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao serializar feedback: " + e.getMessage());
        }
    }
}
