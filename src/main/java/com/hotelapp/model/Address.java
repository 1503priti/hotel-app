package com.hotelapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(generator = "add_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "add_id", sequenceName = "address_id")
	private Integer addressId;
	private String city;
	private long zipcode;
	private String state;
	public Address(String city, long zipcode, String state) {
		super();
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", zipcode=" + zipcode + ", state=" + state + "]";
	}
	
	

}
