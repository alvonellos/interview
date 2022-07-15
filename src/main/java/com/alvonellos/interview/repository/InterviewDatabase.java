package com.alvonellos.interview.repository;

import com.alvonellos.interview.model.InterviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewDatabase extends JpaRepository<InterviewEntity, Integer> {
}
