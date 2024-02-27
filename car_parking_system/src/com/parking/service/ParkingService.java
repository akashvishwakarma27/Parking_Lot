package com.parking.service;

import com.parking.model.Floor;
import com.parking.model.ParkingLot;
import com.parking.model.VehicleSpace;
import com.parking.model.VehicleType;


public class ParkingService {
 private ParkingLot parkingLot;

 public ParkingService(int numFloors, int spacesPerFloor) {
     parkingLot = new ParkingLot(numFloors);
     initializeParkingLot(spacesPerFloor);
 }

 // Method to initialize the parking lot with vehicle spaces
 private void initializeParkingLot(int spacesPerFloor) {
     for (Floor floor : parkingLot.getFloors()) {
         for (VehicleType type : VehicleType.values()) {
             floor.setCapacity(type, spacesPerFloor);
             for (int i = 1; i <= spacesPerFloor; i++) {
                 floor.addVehicleSpace(new VehicleSpace(i, type));
             }
         }
     }
 }

 // Method to park a vehicle and return its token
 public int parkVehicle(String registrationNumber, VehicleType type) {
     for (Floor floor : parkingLot.getFloors()) {
         if (floor.hasSpace(type)) {
             for (VehicleSpace space : floor.getVehicleSpaces().values()) {
                 if (space.isAvailable() && space.getVehicleType() == type) {
                     space.setAvailable(false);
                     return space.getSpaceNumber();
                 }
             }
         }
     }
     return -1; // No available space
 }

 // Method to remove a vehicle from the parking lot
 public void removeVehicle(int floorNumber, int spaceNumber) {
     Floor floor = parkingLot.getFloor(floorNumber);
     if (floor != null) {
         VehicleSpace space = floor.getVehicleSpaces().get(spaceNumber);
         if (space != null) {
             space.setAvailable(true);
         }
     }
 }

 // Method to check if a token is valid
 public boolean isTokenValid(int floorNumber, int spaceNumber, int token) {
     Floor floor = parkingLot.getFloor(floorNumber);
     if (floor != null) {
         VehicleSpace space = floor.getVehicleSpaces().get(spaceNumber);
         return space != null && !space.isAvailable();
     }
     return false;
 }
}
