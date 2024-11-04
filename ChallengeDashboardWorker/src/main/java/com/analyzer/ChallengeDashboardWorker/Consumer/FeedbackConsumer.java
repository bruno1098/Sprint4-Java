package com.analyzer.ChallengeDashboardWorker.Consumer;

import com.analyzer.ChallengeDashboardWorker.Config.RabbitMQConfig;

import com.analyzer.ChallengeDashboardWorker.Model.Feedback;
import com.analyzer.ChallengeDashboardWorker.Service.FeedbackProcessingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedbackConsumer {

    private final FeedbackProcessingService feedbackProcessingService;
    private final ObjectMapper objectMapper;

    @Autowired
    public FeedbackConsumer(FeedbackProcessingService feedbackProcessingService) {
        this.feedbackProcessingService = feedbackProcessingService;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void processarFeedbackNaFila(String feedbackJson) {
        try {

            Feedback feedback = objectMapper.readValue(feedbackJson, Feedback.class);
            feedbackProcessingService.processarFeedback(feedback);
        } catch (Exception e) {
            System.err.println("Erro ao desserializar feedback: " + e.getMessage());
        }
    }
}
