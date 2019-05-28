package com.ltd.pvt.dem.vendoragency.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltd.pvt.dem.vendoragency.api.dto.BusRoute;
import com.ltd.pvt.dem.vendoragency.api.dto.UserName;
import com.ltd.pvt.dem.vendoragency.api.service.BusRouteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.spring.web.json.Json;

@RestController
@RequestMapping("/bussystem/route")
@Api(value = "Root System Service ")
public class BusRouteController {

	@Autowired
	private BusRouteService routrService;

	@ApiOperation(value = " addRoute", nickname = "Add Route")
	@PostMapping("/addNewRoute")
	public ResponseEntity addRoute(@Valid @RequestBody BusRoute dto) {
		String str = routrService.setBusRoute(dto, dto.getUsername());
		return new ResponseEntity(str, HttpStatus.ACCEPTED);

	}

	@ApiOperation(value = " updateRoute", nickname = " set Route")
	@PutMapping("/updateRoute")
	public ResponseEntity<Json> updateRoute() {
		return null;

	}

	@ApiOperation(value = " Get Route detail", nickname = "Get Route Detail")
	@GetMapping("/getRoute")
	public ResponseEntity<Json> getRoute() {
		return null;

	}

	@ApiOperation(value = " close Route", nickname = "Delete Route")
	@DeleteMapping("/deleteRoute")
	public ResponseEntity<Json> deleteRoute() {
		return null;

	}

	@ApiOperation(value = " Get All Route", nickname = "All Route detail")
	@GetMapping("/getAllRoute")
	public ResponseEntity<Json> getAllRoute() {
		return null;

	}
}
