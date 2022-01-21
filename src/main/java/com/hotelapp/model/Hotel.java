package com.hotelapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor because of hotel id generate automatically
public class Hotel {
	
	@Id
	@GeneratedValue(generator = "hotel_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "hotel_id", sequenceName = "hotel_id")
	private Integer hotelId;
	private String hotelName;
	@OneToOne
	private Address address;
	@OneToMany
	private Set<Menu> menuList;
	@ManyToMany
	private Set<Delivery> delivery;
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", address=" + address + ", menuList=" + menuList + ", delivery="
				+ delivery + "]";
	}
	public Hotel(String hotelName, Address address, Set<Menu> menuList, Set<Delivery> delivery) {
		super();
		this.hotelName = hotelName;
		this.address = address;
		this.menuList = menuList;
		this.delivery = delivery;
	}
	
	
	

}
