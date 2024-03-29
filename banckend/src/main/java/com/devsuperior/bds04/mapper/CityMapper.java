package com.devsuperior.bds04.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;

@Component
public class CityMapper {

	private final ModelMapper mapper;

	public CityMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public City toEntity(CityDTO dto) {
		return mapper.map(dto, City.class);
	}

	public CityDTO toDTO(City entity) {
		return mapper.map(entity, CityDTO.class);
	}
}
