package com.criteria.query.rest.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.criteria.query.rest.api.entity.User;

public interface UserRepository extends JpaRepository<User,String>{
   public Boolean existsByUsername(String username);
   public Optional<User> findByUsername(String username);
}
