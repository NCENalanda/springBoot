package com.ltd.pvt.dem.vendoragency.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltd.pvt.dem.vendoragency.api.dto.BusDto;
import com.ltd.pvt.dem.vendoragency.api.service.BusManageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.spring.web.json.Json;


@RestController
@RequestMapping("/bussystem/bus")
@Api(value ="BusService",description="")
public class BusController {
	@Autowired
	private BusManageService service;
	
	@PutMapping("/addNew")
	@ApiOperation(value="Add New Bus")
	public ResponseEntity<Json> addBus(@Valid @RequestBody BusDto dto){
		
		
		return new ResponseEntity(service.addBus(dto),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/addMoreNew")
	@ApiOperation(value="Add New Bus")
	public ResponseEntity<Json> addBus(@RequestBody List<BusDto> listDto){
		
		
		return new ResponseEntity(service.addBus(listDto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getStatus")
	@ApiOperation(value="Get Bus Bus")
	public ResponseEntity<Json> getBusStatus(){
		return new ResponseEntity(" Full  ",HttpStatus.ACCEPTED);
	}
	
	

}
