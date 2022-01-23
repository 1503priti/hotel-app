package com.hotelapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelapp.model.Address;
import com.hotelapp.model.Delivery;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Menu;
import com.hotelapp.service.DeliveryService;
import com.hotelapp.service.HotelService;

@SpringBootApplication
public class SpringHotelappRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringHotelappRestapiApplication.class, args);
	}

	@Autowired
	HotelService hotelService;
	
	@Autowired
	DeliveryService deliveryService;
	
	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("JP Nagar","Manglore",12345,"KAR");
		Menu menu1 = new Menu("Cakes", 20);
		Menu menu2 = new Menu("Burger", 20);
		Set<Menu> menuList = new HashSet<>(Arrays.asList(menu1,menu2));
		Delivery del1 = deliveryService.getDeliveryByPartner("uber");
		Set<Delivery> deliveryList = new HashSet<>(Arrays.asList(del1));
		Hotel hotel = new Hotel("The Cake World",address,menuList,deliveryList);
		hotelService.addHotel(hotel);
		
	}

}
