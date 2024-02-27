package com.parking.model;

import java.util.ArrayList;
import java.util.List;

//Represents the parking lot
public class ParkingLot {
 private List<Floor> floors;

 // Constructor to initialize the parking lot with the given number of floors
 public ParkingLot(int numFloors) {
     this.floors = new ArrayList<>();
     for (int i = 0; i < numFloors; i++) {
         floors.add(new Floor(i + 1));
     }
 }

 // Method to add a floor to the parking lot
 public void addFloor(Floor floor) {
     floors.add(floor);
 }

 // Getter for floors
 public List<Floor> getFloors() {
     return floors;
 }

 // Method to get the number of floors in the parking lot
 public int getNumFloors() {
     return floors.size();
 }

 // Method to get a specific floor by floor number
 public Floor getFloor(int floorNumber) {
     for (Floor floor : floors) {
         if (floor.getFloorNumber() == floorNumber) {
             return floor;
         }
     }
     return null;
 }
}