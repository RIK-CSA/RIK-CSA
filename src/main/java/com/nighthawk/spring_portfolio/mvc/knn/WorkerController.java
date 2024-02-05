package com.nighthawk.spring_portfolio.mvc.knn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Add necessary Spring Boot annotations and imports
@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    private List<Worker> workers = new ArrayList<>(); // Initialize your worker list

    public WorkerController() {
        workers.add(new Worker("John Kim", Arrays.asList("Python", "Java"), "Chicago", true));
        workers.add(new Worker("Jane Zheng", Arrays.asList("C++", "Matlab"), "California", false));
        workers.add(new Worker("Bobby Fischer", Arrays.asList("Java", "JavaScript"), "New York", true));
        workers.add(
                new Worker("David Lee", Arrays.asList("Python", "Java", "Matlab", "JavaScript"), "San Diego", true));
        workers.add(new Worker("Alice Tang", Arrays.asList("Python", "C++", "JavaScript"), "San Diego", true));
        workers.add(new Worker("Amanda Le", Arrays.asList("Python", "Matlab", "JavaScript"), "San Diego", false));
        workers.add(new Worker("James Lo", Arrays.asList("Python", "Java", "Matlab"), "San Diego", false));
        workers.add(new Worker("Jiang Du", Arrays.asList("Java", "Matlab"), "San Diego", false));
        workers.add(new Worker("Sophia Tang", Arrays.asList("Python"), "San Diego", true));
    }

    // Endpoint to add a new worker to the list
    @PostMapping("/add")
    public ResponseEntity<String> addWorker(@RequestBody Worker newWorker) {
        workers.add(newWorker);
        return ResponseEntity.ok("Worker added successfully");
    }

    // Endpoint to find the most relevant worker using KNN
    @PostMapping("/findMostRelevant")
    public ResponseEntity<Worker> findMostRelevantWorker(@RequestBody Worker newWorker,
            @RequestParam int k) {
        Worker mostRelevantWorker = KNNWorkerHiring.findMostRelevantWorker(workers, newWorker, k);
        return ResponseEntity.ok(mostRelevantWorker);
    }

    // Endpoint to get all workers (for testing purposes)
    @GetMapping("/allWorkers")
    public ResponseEntity<List<Worker>> getAllWorkers() {
        return ResponseEntity.ok(workers);
    }

}
