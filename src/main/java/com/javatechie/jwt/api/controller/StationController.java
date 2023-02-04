package com.javatechie.jwt.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javatechie.jwt.api.entity.Station;
import com.javatechie.jwt.api.service.StationService;

@RestController
@RequestMapping("/stations")
public class StationController {
	
	@Autowired
	private StationService stationService;
	
	
	@GetMapping("/")
	public List<Station> findAll(@RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "param", required = false) String param){
		
		 if (limit == null && sort == null && param == null) {
			 return stationService.findAll();
		 }
		 else if (sort != null && param != null && sort.equals("asc")) {
		        return stationService.findAll().stream()
		                .sorted(Comparator.comparing(station -> {
		                    if (param.equals("station_pricing")) {
		                        return station.getStation_pricing();
		                    }
		                    return 0.0;
		                }))
		                .limit(limit == null ? Integer.MAX_VALUE : limit)
		                .collect(Collectors.toList());
		    } else {
		        return new ArrayList<>();
		    }
	}
	
	@GetMapping("/show/{id}")
	public Station findById(@PathVariable Long id) {
		//Station station = stationService.findById(id);
		return stationService.findById(id);
	}
	
	@PostMapping
	public Station save(@RequestParam("image") MultipartFile image,@RequestParam("station_name") String station_name,@RequestParam("station_pricing") Double station_pricing,@RequestParam("station_address") String station_address) throws IOException {
		Station station = new Station( );
		station.setStation_name(station_name);
		station.setStation_pricing(station_pricing);
		station.setStation_address(station_address);
		station.setStation_image(image.getBytes());
		return stationService.save(station);
	}
	
	@PutMapping("update/{station_id}")
	public Station update(@PathVariable Long station_id,@RequestParam(value="image",required=false) MultipartFile image,@RequestParam(value="station_name",required=false) String station_name,@RequestParam(value="station_pricing",required=false) Double station_pricing,@RequestParam(value="station_address",required=false) String station_address) throws IOException {
		Station station = stationService.findById(station_id);
		if(station==null) {
			station = new Station(station_id,station_name,station_pricing,station_address,image.getBytes());
			return station;
		}
		if(station_name!=null) {
			station.setStation_name(station_name);
		}
		if(station_address!=null) {
			station.setStation_address(station_address);
		}
		if(station_pricing!=null) {
			station.setStation_pricing(station_pricing);
		}
		if(image!=null) {
			station.setStation_image(image.getBytes());
		}
		stationService.deleteById(station_id);
		stationService.save(station);
		return station;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		stationService.deleteById(id);
	}
	
}
