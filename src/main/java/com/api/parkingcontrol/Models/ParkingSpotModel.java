package com.api.parkingcontrol.Models; // Package declaration

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity // Marks the class as an entity for JPA
@Table(name = "TB_PARKING_SPOT") // Maps the entity to a specific database table
public class ParkingSpotModel implements Serializable { // Class declaration

    private static final long serialVersionUID = 1L; // Serial version UID

    @Id // Marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Generates automatically the value for the field
    private UUID id; // Field for storing the identifier

    @Column(nullable = false, unique = true, length = 10) // Specifies the column properties
    private String parkingSpotNumber; // Field for storing parking spot number

    @Column(nullable = false, unique = true, length = 7) // Specifies the column properties
    private String licensePlateCar; // Field for storing license plate of the car

    @Column(nullable = false, length = 70) // Specifies the column properties
    private String brandCar; // Field for storing brand of the car

    @Column(nullable = false, length = 70) // Specifies the column properties
    private String modelCar; // Field for storing model of the car

    @Column(nullable = false, length = 70) // Specifies the column properties
    private String colorCar; // Field for storing color of the car

    @Column(nullable = false) // Specifies the column properties
    private LocalDateTime registrationDate; // Field for storing registration date

    @Column(nullable = false, length = 130) // Specifies the column properties
    private String responsibleName; // Field for storing responsible person's name

    @Column(nullable = false, length = 30) // Specifies the column properties
    private String apartment; // Field for storing apartment number

    @Column(nullable = false, length = 30) // Specifies the column properties
    private String block; // Field for storing block information

    // Getter and setter methods for id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // Getter and setter methods for parkingSpotNumber
    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    // Getter and setter methods for licensePlateCar
    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    // Getter and setter methods for brandCar
    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    // Getter and setter methods for modelCar
    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    // Getter and setter methods for colorCar
    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    // Getter and setter methods for registrationDate
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    // Getter and setter methods for responsibleName
    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    // Getter and setter methods for apartment
    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    // Getter and setter methods for block
    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
