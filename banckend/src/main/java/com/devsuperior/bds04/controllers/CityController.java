package com.devsuperior.bds04.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.services.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
	
	private final CityService cityService;
	
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping
	public ResponseEntity<Page<CityDTO>> findAll(Pageable pageable) {
		Page<CityDTO> page = cityService.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}
}
