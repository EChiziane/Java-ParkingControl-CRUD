package com.api.parkingcontrol.Repositories; // Package declaration

import com.api.parkingcontrol.Models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // Marks the class as a repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> { // Interface declaration, extends JpaRepository

    // Method to check if a parking spot exists with the given license plate
    boolean existsByLicensePlateCar(String licensePlateCar);

    // Method to check if a parking spot exists with the given parking spot number
    boolean existsByParkingSpotNumber(String parkingSpotNumber);

    // Method to check if a parking spot exists for the given apartment and block
    boolean existsByApartmentAndBlock(String apartment, String block);
}
