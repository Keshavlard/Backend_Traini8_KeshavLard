package org.example.controller;

import org.example.entity.TrainingCenter;
import org.example.services.TrainingCenterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller for handling TrainingCenter-related API requests
@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService trainingCenterService;

    // Constructor-based dependency injection
    public TrainingCenterController(TrainingCenterService trainingCenterService) {
        this.trainingCenterService = trainingCenterService;
    }

    // API endpoint to create a new TrainingCenter
    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = trainingCenterService.createTrainingCenter(trainingCenter);
        return ResponseEntity.ok(savedCenter);
    }

    // API endpoint to fetch all stored training centers
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(centers); // Returns empty list [] if no data exists
    }
}
