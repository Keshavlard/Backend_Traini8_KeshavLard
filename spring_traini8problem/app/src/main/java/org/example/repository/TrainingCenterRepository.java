package org.example.repository;

import org.example.entity.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;


// Repository interface for TrainingCenter entity

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}
