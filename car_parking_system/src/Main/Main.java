package Main;

import com.parking.model.VehicleType;
import com.parking.service.ParkingService;

public class Main {
 public static void main(String[] args) {
	 
     // Initializing Parking Lot for 2 floors with 2 spaces per floor for each vehicle type
     ParkingService parkingService = new ParkingService(2, 2);

     // Adding vehicles to parking lot
     int token1 = parkingService.parkVehicle("CAR 1", VehicleType.CAR);
     System.out.println("Token for CAR 1: " + token1);

     int token2 = parkingService.parkVehicle("BIKE 2", VehicleType.BIKE);
     System.out.println("Token for BIKE 2: " + token2);

     // Trying to park another car when the capacity is full
     int token3 = parkingService.parkVehicle("BUS 3", VehicleType.BUS);
     if (token3 == -1) {
         System.out.println("Parking lot is full!");
     } else {
         System.out.println("Token for BUS 3: " + token3);
     }

     // Removing a vehicle
     parkingService.removeVehicle(1, token1);
     
     // Checking token validity
     boolean isValidToken = parkingService.isTokenValid(1, 1, token1);
     System.out.println("Token 1 is valid: " + isValidToken);
 }
}