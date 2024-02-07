package com.nighthawk.spring_portfolio.mvc.knn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Add necessary Spring Boot annotations and imports
@RestController
@RequestMapping("/api/worker")
@CrossOrigin(origins = "https://rik-csa.github.io/") // Add the origin of
                                                     // your frontend
                                                     // application
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
        workers.add(new Worker("Sophia Tang", Arrays.asList("Python"), "San Diego, California", true));
        workers.add(new Worker("Alicia Ji", Arrays.asList("Python, Java"), "Cambridge, Massachusetts", true));
        workers.add(new Worker("Evan Ji", Arrays.asList("Java"), "San Diego", true));
        workers.add(new Worker("Ellen Xu", Arrays.asList("Python, Java"), "Sacramento, California", true));
        workers.add(new Worker("Joseph Youm", Arrays.asList("Javascript, HTML, Go, C#, C++"), "San Diego", true));
        workers.add(new Worker("Alex Xiao", Arrays.asList("Javascript, HTML"), "Pittsburgh, Pennsylvania", true));
        workers.add(new Worker("Amanda Yang", Arrays.asList("Python"), "Austin, Texas", true));
        workers.add(new Worker("Ellen Kang", Arrays.asList("Java, C++, Matlab"), "Pittsburgh, Pennsylvania", true));
        workers.add(new Worker("Amanda Wang", Arrays.asList("Java, C++, Matlab"), "Pittsburgh, Pennsylvania", true));
        workers.add(new Worker("Andrea Park", Arrays.asList("Java, C++, Javascript", "Ruby", "Go"),
                "Ithaca, New York", true));
        workers.add(new Worker("Joshua Kim", Arrays.asList("Python, Java, C++", "Matlab", "Javascript"),
                "Pittsburgh, Pennsylvania", true));
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
