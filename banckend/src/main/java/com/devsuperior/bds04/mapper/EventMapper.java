package com.devsuperior.bds04.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;

@Component
public class EventMapper {
	
	private final ModelMapper mapper;
	
	public EventMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public Event toEntity(EventDTO dto) {
		return mapper.map(dto, Event.class);
	}

	public EventDTO toDTO(Event entity) {
		return mapper.map(entity, EventDTO.class);
	}

}
