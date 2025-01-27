package com.reb.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.reb.springboot.dto.PhotoDTO;
import com.reb.springboot.model.Photo;
import com.reb.springboot.repositories.PhotoRepo;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepo photoRepo;

	public List<PhotoDTO> getAll() {

		final Stream<Photo> stream = StreamSupport.stream(photoRepo.findAll().spliterator(),false);
		return stream.map(photo -> PhotoDTO.builder(photo)).collect(Collectors.toList());
		
	}
}