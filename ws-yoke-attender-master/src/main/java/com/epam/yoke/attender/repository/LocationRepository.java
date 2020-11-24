package com.epam.yoke.attender.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.yoke.attender.model.entity.Location;

public interface LocationRepository extends CrudRepository<Location, String> {

}
