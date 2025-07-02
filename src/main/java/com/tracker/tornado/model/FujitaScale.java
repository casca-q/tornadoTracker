package com.tracker.tornado.model;

public enum FujitaScale {
    F0("Light damage"),
    F1("Moderate damage"),
    F2("Significant damage"),
    F3("Severe damage"),
    F4("Devastating damage"),
    F5("Incredible damage");

    private final String description;

    FujitaScale(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}