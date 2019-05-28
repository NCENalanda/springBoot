package com.ltd.pvt.dem.vendoragency.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltd.pvt.dem.vendoragency.api.adaptor.BusAdaptor;
import com.ltd.pvt.dem.vendoragency.api.dao.UserRepository;
import com.ltd.pvt.dem.vendoragency.api.dto.BusDto;
import com.ltd.pvt.dem.vendoragency.api.model.Agency;
import com.ltd.pvt.dem.vendoragency.api.model.Bus;
import com.ltd.pvt.dem.vendoragency.api.model.BusService;

@Service
public class BusServiceImpl implements BusManageService {
	@Autowired
	private BusAdaptor adaptor;
	@Autowired
	private UserRepository userRepo;
	//private BusRepository repo;

	@Override
	public String addBus(BusDto dto) {
		
		Agency agency=userRepo.findByAgencyEmail(dto.getAgencyUsername());
		if(agency==null)
			throw new RuntimeException("User Name not Exist");
		List<BusService> listRoute= agency.getBusServices();
		listRoute.forEach(r1->{
			if(r1.getBusServiceName().equals(dto.getBusRouteName()))
				r1.addBus(adaptor.convertBusDto(dto));
		});
		//userRepo.findByBusServices(dto.getBusRouteName());
		userRepo.save(agency);
		//repo.save(model);
		return "Successfully Added Bus";
	}

	@Override
	public String addBus(List<BusDto> listDto) {
		List<Bus> listModel=null;
		listModel=listDto.stream().map(adaptor::convertBusDto).collect(Collectors.toList());
		//repo.saveAll(listModel);
		return listModel.size()+" Bus are added";
	}

}
