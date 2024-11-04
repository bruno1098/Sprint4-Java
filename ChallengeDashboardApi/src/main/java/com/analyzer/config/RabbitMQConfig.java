package com.analyzer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "feedback-queue";
    public static final String EXCHANGE_NAME = "feedback-exchange";
    public static final String ROUTING_KEY = "feedback-routing-key";

    @Bean
    public Queue feedbackQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange feedbackExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue feedbackQueue, TopicExchange feedbackExchange) {
        return BindingBuilder.bind(feedbackQueue).to(feedbackExchange).with(ROUTING_KEY);
    }
}
