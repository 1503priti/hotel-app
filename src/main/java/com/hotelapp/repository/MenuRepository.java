package com.hotelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
