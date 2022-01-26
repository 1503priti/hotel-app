package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

	// Dervied Queries- to get the list of Menus for a particular hotels
//	getMenusByHotel
	//List<Menu> findByHotelHotelName(String hotelName);

	// @Query with JPQL
	@Query("FROM Menu m INNER JOIN m.hotel WHERE h.hotelName=?1")
	List<Menu> findByHotel(String hotelName);

	// @Query with SQL native Query

}
