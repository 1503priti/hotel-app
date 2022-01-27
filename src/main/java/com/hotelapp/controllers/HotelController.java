package com.hotelapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.hotelapp.model.Hotel;
import com.hotelapp.service.HotelService;

@RestController
@RequestMapping("/hotels-restapi")
public class HotelController {

	@Autowired
	HotelService hotelService;

	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		Hotel newhotel = hotelService.addHotel(hotel);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "one hotel added");
		return ResponseEntity.ok().headers(header).body(newhotel); // eithr create ResponseEntity instance or call the
																	// static methods
	}

	@PutMapping("/hotels")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel) {
		hotelService.updateHotel(hotel);
		// return ResponseEntity.ok().body("updated");
		return ResponseEntity.ok("updated");
	}

	@GetMapping("/hotels/hotel-by-id/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId) {
		Hotel hotel = hotelService.getHotelById(hotelId);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "getting one hotel instance");
		return ResponseEntity.ok().headers(header).body(hotel); // eithr create ResponseEntity instance or call the
																// static methods

	}

	@DeleteMapping("hotels/hotel-by-id/{hotelId}")
	public ResponseEntity<Void> deleteHotel(@PathVariable int hotelId) {
		hotelService.deleteHotel(hotelId);
		return ResponseEntity.ok().build();

	}

	@GetMapping("/hotels/hotel-by-city/{cityName}")
	public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable("cityName") String city) {
		List<Hotel> hotelList = 	hotelService.getHotelsByCity(city);
		return ResponseEntity.ok().body(hotelList);

	}
	

	@GetMapping("/hotels/hotel-by-menu/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelsByMenu(@PathVariable String menuName) {
		List<Hotel> hotelList = 	hotelService.getHotelsByMenu(menuName);
		return ResponseEntity.ok().body(hotelList);

	}
	@GetMapping("/hotels/hotel-by-delivery/{partnerName}")
	public ResponseEntity<List<Hotel>> getHotelsByDelivery(@PathVariable String partnerName){
		List<Hotel> hotelList = hotelService.getHotelsByDelivery(partnerName);
		return ResponseEntity.ok().body(hotelList);
	}
	@GetMapping("/hotels/hotel-by-location/{location}")
	public ResponseEntity<List<Hotel>> getHotelsByLocation(@PathVariable String location){
		List<Hotel> hotelList = hotelService.getHotelsByLocation(location);
		return ResponseEntity.ok().body(hotelList);
	}
	@GetMapping("/hotels/hotel-by-location/{location}/menuName/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelsByLocationAndMenu(@PathVariable String location,@PathVariable String menuName){
		List<Hotel> hotelList = hotelService.getHotelsByLocationAndMenu(location, menuName);
		return ResponseEntity.ok().body(hotelList);
	}
	/*
	
	 * 
	 * List<Hotel> getHotelsByMenu(String menuName);
	 * 
	 * List<Hotel> getHotelsByDelivery(String partnerName);
	 * 
	 * List<Hotel> getHotelsByLocation(String location);
	 * 
	 * List<Hotel> getHotelsByLocationAndMenu(String location, String menuName);
	 */

}
