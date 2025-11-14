
package com.smartcommute.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "bus_locations")
public class BusLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)

    private int busId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;
    private String busRoute;

    public Long getId() {
        return id;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }


}
//package com.smartcommute.entity;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class BusLocation {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String busId;
//    private double latitude;
//    private double longitude;
//    private LocalDateTime timestamp;
//
//    // Getters and setters
//}