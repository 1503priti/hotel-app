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
import com.hotelapp.service.HotelService;

@SpringBootApplication
public class SpringHotelappRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringHotelappRestapiApplication.class, args);
	}

	@Autowired
	HotelService hotelService;
	
	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("ABD Nagar","Banglore",56789,"KAR");
		Menu menu1 = new Menu("Paratha", 120);
		Menu menu2 = new Menu("Pizza", 130);
		Set<Menu> menuList = new HashSet<>(Arrays.asList(menu1,menu2));
		Delivery del1 = new Delivery("swiggy",120);
		Delivery del2 = new Delivery("uber",130);
		Set<Delivery> deliveryList = new HashSet<>(Arrays.asList(del1,del2));
		Hotel hotel = new Hotel("A2B",address,menuList,deliveryList);
		hotelService.addHotel(hotel);
		
	}

}
