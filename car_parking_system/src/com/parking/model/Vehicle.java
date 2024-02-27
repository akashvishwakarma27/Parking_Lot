package com.parking.model;

public class Vehicle {
 private String registrationNumber;
 private VehicleType type;

 // Constructor 
 public Vehicle(String registrationNumber, VehicleType type) {
     this.registrationNumber = registrationNumber;
     this.type = type;
 }

 // Getter 
 public String getRegistrationNumber() {
     return registrationNumber;
 }

 // Getter 
 public VehicleType getType() {
     return type;
 }
}