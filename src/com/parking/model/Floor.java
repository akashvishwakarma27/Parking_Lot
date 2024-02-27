package com.parking.model;

import java.util.HashMap;
import java.util.Map;


public class Floor {
 private int floorNumber;
 private Map<VehicleType, Integer> capacityPerType;
 private Map<Integer, VehicleSpace> vehicleSpaces;

 // Constructor to initialize the floor with a floor number
 public Floor(int floorNumber) {
     this.floorNumber = floorNumber;
     this.capacityPerType = new HashMap<>();
     this.vehicleSpaces = new HashMap<>();
 }

 // Getter for floor number
 public int getFloorNumber() {
     return floorNumber;
 }

 // Method to set capacity for a specific vehicle type
 public void setCapacity(VehicleType type, int capacity) {
     capacityPerType.put(type, capacity);
 }

 // Method to get capacity for a specific vehicle type
 public int getCapacity(VehicleType type) {
     return capacityPerType.getOrDefault(type, 0);
 }

 // Method to check if there's space available for a specific vehicle type
 public boolean hasSpace(VehicleType type) {
     return getAvailableSpaces(type) > 0;
 }

 // Method to get available spaces for a specific vehicle type
 public int getAvailableSpaces(VehicleType type) {
     return Math.max(0, getCapacity(type) - getOccupiedSpaces(type));
 }

 // Method to add a vehicle space to the floor
 public void addVehicleSpace(VehicleSpace space) {
     vehicleSpaces.put(space.getSpaceNumber(), space);
 }

 // Method to remove a vehicle space from the floor
 public void removeVehicleSpace(int spaceNumber) {
     vehicleSpaces.remove(spaceNumber);
 }

 // Method to get occupied spaces for a specific vehicle type
 public int getOccupiedSpaces(VehicleType type) {
     int occupied = 0;
     for (VehicleSpace space : vehicleSpaces.values()) {
         if (space.getVehicleType() == type) {
             occupied++;
         }
     }
     return occupied;
 }
 
 public Map<Integer, VehicleSpace> getVehicleSpaces() {
     return vehicleSpaces;
 }
}
