package com.api.parkingcontrol.Services; // Package declaration

import com.api.parkingcontrol.Models.ParkingSpotModel;
import com.api.parkingcontrol.Repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service // Marks the class as a service
public class ParkingSpotService { // Class declaration

    final ParkingSpotRepository parkingSpotRepository; // Instance variable for ParkingSpotRepository

    // Constructor for ParkingSpotService
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository; // Constructor injection for ParkingSpotRepository
    }

    @Transactional // Marks the method for transaction management
    // Method to save parking spot
    public ParkingSpotModel saveParkingSpot(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel); // Saving parking spot
    }

    // Method to check if parking spot exists by license plate
    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar); // Checking existence by license plate
    }

    // Method to find all parking spots
    public List<ParkingSpotModel> findAllParkingSpots() {
        return parkingSpotRepository.findAll(); // Retrieving all parking spots
    }

    // Method to find parking spot by ID
    public Optional<ParkingSpotModel> findParkingSpotById(UUID id) {
        return parkingSpotRepository.findById(id); // Retrieving parking spot by ID
    }

    // Method to delete parking spot
    public void deleteParkingSpot(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel); // Deleting parking spot
    }

    // Method to check if parking spot exists by number
    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber); // Checking existence by number
    }

    // Method to check if parking spot exists by apartment and block
    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block); // Checking existence by apartment and block
    }
}
