package org.example.services;

import jakarta.transaction.Transactional;
import org.example.entity.TrainingCenter;
import org.example.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for TrainingCenter business logic
@Service
@Transactional
public class TrainingCenterService {
    private final TrainingCenterRepository trainingCenterRepository;

    // Constructor-based dependency injection
    public TrainingCenterService(TrainingCenterRepository trainingCenterRepository) {
        this.trainingCenterRepository = trainingCenterRepository;
    }

    // Method to create and save a new TrainingCenter
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        trainingCenter.setCreatedOn(System.currentTimeMillis()); // Auto-generate timestamp
        return trainingCenterRepository.save(trainingCenter);
    }

    // Method to fetch all stored training centers
    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll(); // Returns an empty list [] if no records exist
    }
}
