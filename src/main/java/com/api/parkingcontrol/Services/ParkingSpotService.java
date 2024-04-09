package com.api.parkingcontrol.Services;
import com.api.parkingcontrol.Models.ParkingSpotModel;
import com.api.parkingcontrol.Repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public List<ParkingSpotModel>findAll() {
        return parkingSpotRepository.findAll();
    }

    public Optional findById(UUID id) {
        return  parkingSpotRepository.findById(id);
    }

    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }
}
