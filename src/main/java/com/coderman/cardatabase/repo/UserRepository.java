package com.coderman.cardatabase.repo;

import com.coderman.cardatabase.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

}
