package com.smartcommute.service;

import com.smartcommute.dto.BusLocationDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusLocationService {
    private final List<BusLocationDTO> locationList = new ArrayList<>();

    public void saveLocation(BusLocationDTO location) {
        locationList.add(location);
    }

    public List<BusLocationDTO> getAllLocations() {
        return locationList;
    }
}

// package com.smartcommute.service;

// import com.smartcommute.dto.BusLocationDTO;
// import com.smartcommute.entity.BusLocation;
// import com.smartcommute.repository.BusLocationRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;

// @Service
// public class BusLocationService {

//     @Autowired
//     private BusLocationRepository repository;

//     public void saveLocation(BusLocationDTO dto) {
//         BusLocation location = new BusLocation();
//         location.setBusId(dto.getBusId());
//         location.setLatitude(dto.getLatitude());
//         location.setLongitude(dto.getLongitude());
//         location.setTimestamp(LocalDateTime.parse(dto.getTimestamp()));
//         repository.save(location);
//     }
// }