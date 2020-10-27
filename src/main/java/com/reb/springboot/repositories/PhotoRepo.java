package com.reb.springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.reb.springboot.model.Photo;

public interface PhotoRepo extends CrudRepository<Photo, Integer> {

}
