package com.ltd.pvt.dem.vendoragency.api.adaptor;

import org.springframework.stereotype.Component;

import com.ltd.pvt.dem.vendoragency.api.dto.BusRoute;
import com.ltd.pvt.dem.vendoragency.api.model.BusService;


@Component
public class BusRouteAdaptorImpl implements BusRouteAdaptor {

	@Override
	public BusService convertBusRouteDto(BusRoute dto) {
		BusService model=null;
		model=new BusService();
		model.setBusServiceName(dto.getBusRouteName());
		model.setDestination(dto.getDestination());
		model.setOrigin(dto.getOrigin());
		return model;
	}

}
