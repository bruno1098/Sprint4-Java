package com.analyzer.repository;

import com.analyzer.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    // Método para buscar os 10 feedbacks mais recentes
    List<Feedback> findTop10ByOrderByDataDesc();
}
