package com.ltd.pvt.dem.vendoragency.api.adaptor;

import com.ltd.pvt.dem.vendoragency.api.dto.BusDto;
import com.ltd.pvt.dem.vendoragency.api.model.Bus;

public interface BusAdaptor {
	
	Bus convertBusDto(BusDto dto);

}
