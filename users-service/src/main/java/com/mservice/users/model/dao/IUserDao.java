package com.mservice.users.model.dao;

import com.mservice.users.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {

  @Override
  Optional<User> findById(Long userId);
}
