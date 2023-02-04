package com.javatechie.jwt.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;



@Entity
public class Station {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long station_id;
    private String station_name;
    private double station_pricing;
    private String station_address; 
    @Lob
    private byte[] station_image;

	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Station(Long station_id, String station_name, double station_pricing, String station_address,
			byte[] station_image) {
		super();
		this.station_id = station_id;
		this.station_name = station_name;
		this.station_pricing = station_pricing;
		this.station_address = station_address;
		this.station_image = station_image;
	}


	public Long getStation_id() {
		return station_id;
	}

	public void setStation_id(Long station_id) {
		this.station_id = station_id;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public double getStation_pricing() {
		return station_pricing;
	}

	public void setStation_pricing(double station_pricing) {
		this.station_pricing = station_pricing;
	}

	public String getStation_address() {
		return station_address;
	}

	public void setStation_address(String station_address) {
		this.station_address = station_address;
	}

	public byte[] getStation_image() {
		return station_image;
	}

	public void setStation_image(byte[] station_image) {
		this.station_image = station_image;
	}

	
	
    
    
    
}
