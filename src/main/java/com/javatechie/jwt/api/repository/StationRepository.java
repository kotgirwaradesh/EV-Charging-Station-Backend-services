package com.javatechie.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javatechie.jwt.api.entity.Station;

public interface StationRepository extends JpaRepository<Station, Long> {

}
