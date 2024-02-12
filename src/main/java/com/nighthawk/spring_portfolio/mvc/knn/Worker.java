package com.nighthawk.spring_portfolio.mvc.knn;

import java.util.List;

public class Worker {
    private String name;
    List<String> languagesKnown;
    String preferredLocation;
    private boolean internshipPreferred;

    // Constructors (including a no-arg constructor)

    public Worker() {
    }

    public Worker(String name, List<String> languagesKnown, String preferredLocation,
            boolean internshipPreferred) {
        this.name = name;
        this.languagesKnown = languagesKnown;
        this.preferredLocation = preferredLocation;
        this.internshipPreferred = internshipPreferred;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLanguagesKnown() {
        return languagesKnown;
    }

    public void setLanguagesKnown(List<String> languagesKnown) {
        this.languagesKnown = languagesKnown;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public boolean isInternshipPreferred() {
        return internshipPreferred;
    }

    public void setInternshipPreferred(boolean internshipPreferred) {
        this.internshipPreferred = internshipPreferred;
    }
}
