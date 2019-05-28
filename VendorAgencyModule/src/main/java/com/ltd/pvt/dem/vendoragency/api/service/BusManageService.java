package com.ltd.pvt.dem.vendoragency.api.service;

import java.util.List;

import com.ltd.pvt.dem.vendoragency.api.dto.BusDto;

public interface BusManageService {
	
	String addBus(BusDto dto);
	String addBus(List<BusDto> listBus);
	

}
