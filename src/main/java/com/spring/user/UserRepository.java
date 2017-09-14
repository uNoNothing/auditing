package com.spring.user;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.repository.CrudRepository;

@JaversSpringDataAuditable
public interface UserRepository extends CrudRepository<User, Integer> {

}
