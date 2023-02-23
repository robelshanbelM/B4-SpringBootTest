package com.swaggerwith.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swaggerwith.spring.model.Location;

import com.swaggerwith.spring.Repository.LocationRepository;

@RestController
public class Controllers {

	
	@Autowired
	LocationRepository locationRepository;

	
	
	
	@PostMapping("/location")

	public ResponseEntity<?> saveLocation( @RequestBody Location location){
		
		
		
		
		locationRepository.save(location);
		
		
		return new ResponseEntity<>(location,HttpStatus.CREATED);
		
		
		
	}
	
	
	
	
	
	
	@GetMapping("/location")

	public List<Location>listofLocation(){
		
		System.out.println(locationRepository.findAll());
		return locationRepository.findAll();
		
	}
	
	@GetMapping("/location/{id}")
	
	public ResponseEntity<?> findLocationById( @PathVariable("id")  int id  ) {
		
		
	   Optional<Location> optional=	locationRepository.findById(id);
	   
	   if(optional.isPresent()) {
		   
		   return new ResponseEntity<>(optional,HttpStatus.FOUND) ;
		   
	   }
		
	   else {
		   
		   return new ResponseEntity<String>("Id is not found",HttpStatus.NOT_FOUND);
	   }
	}
	
	@PatchMapping("/location/{id}")
	
	public ResponseEntity<?> updateLoction( @PathVariable("id") int id, @RequestBody Location location ){
		
		Optional<Location> optional= locationRepository.findById(id);
		
		if (optional.isPresent()) {
			
			Location location2=optional.get();
			
			location2.setLatitude(location.getLatitude());
			location2.setLongitude(location.getLongitude());
			location2.setMapLocation(location.getMapLocation());
			
			return new ResponseEntity<>(locationRepository.save(location2),HttpStatus.CREATED);
		}
		
		else {
			 return new ResponseEntity<>(locationRepository.save(location),HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	
	@DeleteMapping("/location/{id}")
	
	public ResponseEntity<?>deleteLocation(@PathVariable("id") int id){
		
		
		locationRepository.deleteById(id);
		
		return new ResponseEntity<String>(" location is deleted",HttpStatus.NO_CONTENT);
		
	}
	
	
	
	
	
	
}
