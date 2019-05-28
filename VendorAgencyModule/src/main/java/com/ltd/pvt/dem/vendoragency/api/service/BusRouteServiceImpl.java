package com.ltd.pvt.dem.vendoragency.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltd.pvt.dem.vendoragency.api.adaptor.BusRouteAdaptor;
import com.ltd.pvt.dem.vendoragency.api.dao.UserRepository;
import com.ltd.pvt.dem.vendoragency.api.dto.BusRoute;
import com.ltd.pvt.dem.vendoragency.api.model.Agency;
import com.ltd.pvt.dem.vendoragency.api.model.BusService;

@Service
public class BusRouteServiceImpl implements BusRouteService {

	@Autowired
	private UserRepository agencyRepo;

	@Autowired
	private BusRouteAdaptor adaptor;

	@Override
	public String setBusRoute(BusRoute dto, String userName) {
		// TODO Auto-generated method stub
		Agency agency = null;
		List<BusService> listSame = new ArrayList<>();
		// convert dto to model
		try {
			BusService model = adaptor.convertBusRouteDto(dto);

			// fetch the records
			agency = agencyRepo.findByAgencyEmail(userName);
			if (agency == null)
				throw new RuntimeException(" Agency Username  Not Exist   ");
			// add to list
			listSame.add(model);
			agency.setBusServices(listSame);
			agency = agencyRepo.save(agency);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(" Internal Problem   ");
		}
		return "Successful Added";

	}

	private boolean match(BusService b1, BusService b2) {
		BiPredicate<BusService, BusService> p = (m1, m2) -> m1.getBusServiceName().equals(m2.getBusServiceName());
		return p.test(b1, b2);
	}

}
