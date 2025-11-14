package com.smartcommute.repository;

import com.smartcommute.entity.BusLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusLocationRepository extends JpaRepository<BusLocation, Long> {
    List<BusLocation> findByBusRoute(String route);

    List<BusLocation> findByBusId(int busId);

    @Query("SELECT b FROM BusLocation b WHERE b.busId = :busId ORDER BY b.timestamp DESC")
    List<BusLocation> findLatestByBusId(@Param("busId") int busId);

}