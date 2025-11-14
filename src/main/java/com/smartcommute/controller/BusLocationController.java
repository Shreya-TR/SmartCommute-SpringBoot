package com.smartcommute.controller;

import com.smartcommute.dto.BusLocationDTO;
import com.smartcommute.entity.BusLocation;
import com.smartcommute.service.BusLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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

    @GetMapping("/bus-location/route/{route}")
    public ResponseEntity<List<BusLocation>> getLocationsByRoute(@PathVariable String route) {
        return ResponseEntity.ok(locationService.findByBusRoute(route));
    }

    @GetMapping("/bus-location/bus/{busId}")
    public ResponseEntity<List<BusLocation>> getLocationsByBusId(@PathVariable int busId) {
        return ResponseEntity.ok(locationService.findByBusId(busId));
    }

    @GetMapping("/bus-location/bus/{busId}/latest")
    public ResponseEntity<BusLocation> getLatestLocation(@PathVariable int busId) {
        return ResponseEntity.ok(locationService.findLatestLocationByBusId(busId));
    }
}