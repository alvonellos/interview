package com.alvonellos.interview.repository;

import com.alvonellos.interview.model.MemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeRepository extends JpaRepository<MemeEntity, Long> {
}