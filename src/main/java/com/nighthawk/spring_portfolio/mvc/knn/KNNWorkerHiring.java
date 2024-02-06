package com.nighthawk.spring_portfolio.mvc.knn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KNNWorkerHiring {

    // KNN algorithm
    public static Worker findMostRelevantWorker(List<Worker> workers, Worker newWorker, int k) {
        Map<Double, Worker> distanceMap = new HashMap<>();

        // Calculate Euclidean distance for each worker
        for (Worker worker : workers) {
            double distance = calculateDistance(worker, newWorker);
            distanceMap.put(distance, worker);
        }

        // Sort distances and get the top k neighbors
        List<Double> distances = new ArrayList<>(distanceMap.keySet());
        Collections.sort(distances);

        // Return the most relevant worker
        return distanceMap.get(distances.get(0));
    }

    private static double calculateDistance(Worker worker1, Worker worker2) {
        // Simple distance calculation based on preferences
        double langDistance = calculateLanguageDistance(worker1.languagesKnown, worker2.languagesKnown);
        double locationDistance = worker1.preferredLocation.equals(worker2.preferredLocation) ? 0 : 1;

        // Euclidean distance
        return Math.sqrt(Math.pow(langDistance, 2) + Math.pow(locationDistance, 2));
    }

    private static double calculateLanguageDistance(List<String> lang1, List<String> lang2) {
        // Jaccard similarity for language distance
        List<String> union = new ArrayList<>(lang1);
        union.addAll(lang2);

        List<String> intersection = new ArrayList<>(lang1);
        intersection.retainAll(lang2);

        return 1 - ((double) intersection.size() / union.size());
    }
}