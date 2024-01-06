package com.devsuperior.bds04.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.mapper.EventMapper;
import com.devsuperior.bds04.repositories.EventRepository;

@Service
public class EventService {
	
	private final EventRepository eventRepository;
	private final EventMapper mapper;
	
	public EventService(EventRepository eventRepository, EventMapper mapper) {
		this.eventRepository = eventRepository;
		this.mapper = mapper;
	}
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event entity = mapper.toEntity(dto);
		entity = eventRepository.save(entity);
		dto = mapper.toDTO(entity);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public Page<EventDTO> findAll(Pageable pageable) {
		Page<Event> page = eventRepository.findAll(pageable);
		return page.map((entity) -> mapper.toDTO(entity));
	}
}
