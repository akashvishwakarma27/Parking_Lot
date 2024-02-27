package com.parking.model;

public class VehicleSpace {
 private int spaceNumber;
 private boolean available;
 private VehicleType vehicleType;

 // Constructor
 public VehicleSpace(int spaceNumber, VehicleType vehicleType) {
     this.spaceNumber = spaceNumber;
     this.available = true;
     this.vehicleType = vehicleType;
 }

 // Getter and Setter Methods
 public int getSpaceNumber() {
     return spaceNumber;
 }

 public boolean isAvailable() {
     return available;
 }

 public void setAvailable(boolean available) {
     this.available = available;
 }

 public VehicleType getVehicleType() {
     return vehicleType;
 }
}