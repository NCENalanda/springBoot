package com.ltd.pvt.dem.vendoragency.api.adaptor;

import org.springframework.stereotype.Component;

import com.ltd.pvt.dem.vendoragency.api.dto.BusDto;
import com.ltd.pvt.dem.vendoragency.api.model.Bus;

@Component
public class BusConvertalState implements BusAdaptor {

	@Override
	public Bus convertBusDto(BusDto dto) {
		Bus model=new Bus();
		model.setBusNo(dto.getBusNo());
		model.setTotalSeat(dto.getTotalSeat());
		model.setIsAc(dto.getIsAC());
		model.setBusType(dto.getType());
		return model;
	}


}
