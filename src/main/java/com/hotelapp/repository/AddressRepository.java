package com.hotelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Address;
import com.hotelapp.model.Hotel;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
