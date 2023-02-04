package com.javatechie.jwt.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.jwt.api.entity.Station;
import com.javatechie.jwt.api.repository.StationRepository;

@Service
public class StationService {

	//get all the charging station
	//get /show/:id -- single charging station
	//post / add charging station
	//put /:id/edit -- change detail
	//delete /delete/:id -- delete that station
	
	@Autowired
	private StationRepository stationRepository;
	
	public List<Station> findAll(){
		return stationRepository.findAll();
	}
	
	public Station findById(Long id) {
		return stationRepository.findById(id).orElse(null);
	}
	
	public Station save(Station station) {
		return stationRepository.save(station);
	}
	
	public void deleteById(Long id) {
		stationRepository.deleteById(id);
	}
}
