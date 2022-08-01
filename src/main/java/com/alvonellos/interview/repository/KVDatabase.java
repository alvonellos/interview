package com.alvonellos.interview.repository;

import com.alvonellos.interview.model.KVEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KVDatabase extends JpaRepository<KVEntity, Integer> {
}
