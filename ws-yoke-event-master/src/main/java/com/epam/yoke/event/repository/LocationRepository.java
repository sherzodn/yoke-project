package com.epam.yoke.event.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.yoke.event.entity.Location;

public interface LocationRepository extends CrudRepository<Location, String> {

}
