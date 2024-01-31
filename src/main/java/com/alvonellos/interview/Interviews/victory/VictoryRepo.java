package com.alvonellos.interview.Interviews.victory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VictoryRepo extends JpaRepository<VictoryEntity, UUID> {
}
