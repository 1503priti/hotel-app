package com.hotelapp.service;

import java.util.List;

import com.hotelapp.model.Menu;

public interface MenuService {

	List<Menu> getMenusByHotel(String hotelName);

}
