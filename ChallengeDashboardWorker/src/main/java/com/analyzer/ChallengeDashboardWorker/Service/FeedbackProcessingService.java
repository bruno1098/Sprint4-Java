package com.analyzer.ChallengeDashboardWorker.Service;


import com.analyzer.ChallengeDashboardWorker.Model.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackProcessingService {

    public void processarFeedback(Feedback feedback) {

        System.out.println("Processando feedback: " + feedback.getDescricao());
    }
}

