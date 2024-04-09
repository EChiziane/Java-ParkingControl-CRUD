package com.api.parkingcontrol.Services;
import com.api.parkingcontrol.Models.ParkingSpotModel;
import com.api.parkingcontrol.Repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;


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

}
