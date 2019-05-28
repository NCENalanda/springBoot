package com.ltd.pvt.dem.vendoragency.api.adaptor;

import com.ltd.pvt.dem.vendoragency.api.dto.BusRoute;
import com.ltd.pvt.dem.vendoragency.api.model.BusService;

public interface BusRouteAdaptor {
	
	BusService convertBusRouteDto(BusRoute dto);

}
