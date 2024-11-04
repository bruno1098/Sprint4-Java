package com.analyzer.Facade;

import com.analyzer.Producer.FeedbackProducer;
import com.analyzer.model.Feedback;
import com.analyzer.repository.FeedbackRepository;
import com.analyzer.service.FeedbackAiService;
import com.analyzer.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackFacade {


    @Autowired
    private FeedbackRepository feedbackRepository;

    private final FeedbackService feedbackService;
    private final FeedbackProducer feedbackProducer;
    private final FeedbackAiService feedbackAIService;

    @Autowired
    public FeedbackFacade(FeedbackService feedbackService, FeedbackProducer feedbackProducer, FeedbackAiService feedbackAIService) {
        this.feedbackService = feedbackService;
        this.feedbackProducer = feedbackProducer;
        this.feedbackAIService = feedbackAIService;
    }

    public Feedback processarFeedback(Feedback feedback) {
        feedbackAIService.analisarFeedback(feedback);
        Feedback feedbackSalvo = feedbackService.salvar(feedback);
        feedbackProducer.enviarFeedbackParaFila(feedbackSalvo);
        return feedbackSalvo;
    }

    public List<Feedback> listarTodos() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> buscarPorId(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback salvar(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deletarPorId(Long id) {
        feedbackRepository.deleteById(id);
    }

    public long count() {
        return feedbackRepository.count();
    }

    public List<Feedback> findRecentFeedbacks() {
        return feedbackRepository.findTop10ByOrderByDataDesc();
    }

}
