package com.smartcommute.service;

import com.smartcommute.dto.BusLocationDTO;
import com.smartcommute.entity.BusLocation;
import com.smartcommute.repository.BusLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BusLocationService {

    private final BusLocationRepository repository;

    @Autowired
    public BusLocationService(BusLocationRepository repository) {
        this.repository = repository;
    }

    public void saveLocation(BusLocationDTO dto) {
        BusLocation location = new BusLocation();
        location.setBusId(dto.getBusId());
        location.setLatitude(dto.getLatitude());
        location.setLongitude(dto.getLongitude());

        // Convert timestamp from String to LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime parsedTimestamp = LocalDateTime.parse(dto.getTimestamp(), formatter);
        location.setTimestamp(parsedTimestamp);

        location.setBusRoute(dto.getBusRoute());
        repository.save(location);
    }

    public List<BusLocation> getAllLocations() {
        return repository.findAll();
    }

    public List<BusLocation> findByBusRoute(String route) {
        return repository.findByBusRoute(route);
    }

    public List<BusLocation> findByBusId(int busId) {
        return repository.findByBusId(busId);
    }
    public BusLocation findLatestLocationByBusId(int busId) {
        List<BusLocation> results = repository.findLatestByBusId(busId);
        if (results == null || results.isEmpty()) {
            System.out.println("No location data found for busId: " + busId);
            return null;
        }
        return results.get(0);
    }

}

