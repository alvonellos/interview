package com.alvonellos.interview.Interviews.Walmart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIPActionItemsRepository extends JpaRepository<IIPActionItemEntity, UUID> {
}