package com.devsuperior.bds04.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.mapper.CityMapper;
import com.devsuperior.bds04.repositories.CityRepository;

@Service
public class CityService {
	
	private final CityRepository cityRepository;
	private final CityMapper mapper;
	
	public CityService(CityRepository cityRepository, CityMapper mapper) {
		this.cityRepository = cityRepository;
		this.mapper = mapper;
	}
	
	@Transactional
	public CityDTO insert(CityDTO dto) {
		City entity = mapper.toEntity(dto);
		entity = cityRepository.save(entity);
		dto = mapper.toDTO(entity);
		return dto;
	}

	@Transactional(readOnly = true)
	public Page<CityDTO> findAll(Pageable pageable) {
		Page<City> page = cityRepository.findAll(pageable);
		return page.map((entity) -> mapper.toDTO(entity));
	}
}
