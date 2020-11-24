package com.epam.yoke.event.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.yoke.event.entity.User;

public interface UserRepository extends CrudRepository<User, String> {

}
