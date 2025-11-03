package com.smartcommute.controller;

import com.smartcommute.dto.BusLocationDTO;
import com.smartcommute.service.BusLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BusLocationController {

    private final BusLocationService locationService;

    public BusLocationController(BusLocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/bus-location")
    public ResponseEntity<String> updateLocation(@RequestBody BusLocationDTO location) {
        locationService.saveLocation(location);
        return ResponseEntity.ok("Location saved");
    }
//     @GetMapping("/bus-location")
// public ResponseEntity<String> testBusLocation() {
//     return ResponseEntity.ok("Bus location endpoint is alive!");
// }

    @GetMapping("/bus-location/all")
    public ResponseEntity<List<BusLocationDTO>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }
}

// package com.smartcommute.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class BusLocationController {

//     @GetMapping("/bus-location")
//     public ResponseEntity<String> testBusLocation() {
//         return ResponseEntity.ok("Bus location endpoint is alive!");
//     }
// }

// package com.smartcommute.controller;

// import com.smartcommute.dto.BusLocationDTO;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api")
// public class BusLocationController {

//     @PostMapping("/bus-location")
//     public ResponseEntity<String> updateLocation(@RequestBody BusLocationDTO location) {
//         System.out.println("Received location: " + location.getBusId() + " at " + location.getLatitude() + ", " + location.getLongitude());
//         return ResponseEntity.ok("Location updated");
        
    
//     }
// }