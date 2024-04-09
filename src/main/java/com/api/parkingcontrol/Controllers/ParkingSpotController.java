package com.api.parkingcontrol.Controllers;

import com.api.parkingcontrol.Dtos.parkingSpotDto;
import com.api.parkingcontrol.Models.ParkingSpotModel;
import com.api.parkingcontrol.Services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController // Marks the class as a REST controller
@CrossOrigin(origins = "*", maxAge = 3600) // Enables Cross-Origin Resource Sharing (CORS)
@RequestMapping("/parking-spot") // Maps HTTP requests to a specific handler method
public class ParkingSpotController {

    final ParkingSpotService parkingSpotService; // Instance variable for ParkingSpotService

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService; // Constructor injection for ParkingSpotService
    }

    // Handler method to save a parking spot
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid parkingSpotDto parkingSpotDto) {

        // Checking if license plate car is already in use
        if (parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        }

        // Checking if parking spot number is already in use
        if (parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
        }

        // Checking if parking spot is already registered for this apartment/block
        if (parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
        }

        var parkingSpotModel = new ParkingSpotModel(); // Creating new instance of ParkingSpotModel
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel); // Copying properties from DTO to Model
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC"))); // Setting registration date
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.saveParkingSpot(parkingSpotModel)); // Returning response
    }

    // Handler method to retrieve all parking spots
    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAllParkingSpots()); // Returning all parking spots
    }

    // Handler method to retrieve a single parking spot by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object>  getOneParkingSpot(@PathVariable(value = "id") UUID id){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findParkingSpotById(id); // Retrieving optional parking spot by ID
        if (!parkingSpotModelOptional.isPresent()) // Checking if parking spot is present
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No parking spot found"); // Returning not found response if not present
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get()); // Returning parking spot if present
    }

    // Handler method to delete a parking spot by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value="id") UUID id){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findParkingSpotById(id); // Retrieving optional parking spot by ID
        if (!parkingSpotModelOptional.isPresent()) // Checking if parking spot is present
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No parking spot found"); // Returning not found response if not present
        parkingSpotService.deleteParkingSpot(parkingSpotModelOptional.get()); // Deleting parking spot
        return ResponseEntity.status(HttpStatus.OK).body("Parking spot Deleted Successfully."); // Returning success response
    }

    // Handler method to update a parking spot by ID
    @PutMapping("/{id}")
    public ResponseEntity<Object> upDateParkingSpot(@PathVariable(value = "id") UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findParkingSpotById(id); // Retrieving optional parking spot by ID
        if (!parkingSpotModelOptional.isPresent()) // Checking if parking spot is present
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No parking spot found"); // Returning not found response if not present
        var parkingSpotModel = new ParkingSpotModel(); // Creating new instance of ParkingSpotModel
        BeanUtils.copyProperties(parkingSpotModel, parkingSpotModel); // Copying properties from DTO to Model
        parkingSpotModel.setId(parkingSpotModelOptional.get().getId()); // Setting ID
        parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate()); // Setting registration date
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.saveParkingSpot(parkingSpotModel)); // Saving and returning updated parking spot
    }
}
