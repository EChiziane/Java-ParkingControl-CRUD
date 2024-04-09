
package com.api.parkingcontrol.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class parkingSpotDto {
    @NotBlank // Ensuring parkingSpotNumber is not blank
    private String parkingSpotNumber;

    @NotBlank // Ensuring licensePlateCar is not blank
    @Size(max = 7) // Limiting the size of licensePlateCar to 7 characters
    private String licensePlateCar;

    @NotBlank // Ensuring brandCar is not blank
    private String brandCar;

    @NotBlank // Ensuring modelCar is not blank
    private String modelCar;

    @NotBlank // Ensuring colorCar is not blank
    private String colorCar;

    @NotBlank // Ensuring responsibleName is not blank
    private String responsibleName;

    @NotBlank // Ensuring apartment is not blank
    private String apartment;

    @NotBlank // Ensuring block is not blank
    private String block;

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