package com.epam.yoke.attender.repository;

import com.epam.yoke.attender.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
