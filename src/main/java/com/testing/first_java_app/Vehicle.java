package com.testing.first_java_app;

public class Vehicle {
    private String location;
    private String license_plate;

    public Vehicle() {
        this.location = "UNKNOWN";
        this.license_plate = "UNKNOWN";
    }

    public Vehicle(String location, String license_plate) {
        this.location = location;
        this.license_plate = license_plate;
    }

    public String toString() {
        return "License plate : " + license_plate + "\n" +
                "Location : " + location;
    }

}
