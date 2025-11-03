package com.smartcommute.repository;

import com.smartcommute.entity.BusLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusLocationRepository extends JpaRepository<BusLocation, Long> {}