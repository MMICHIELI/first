package com.mmi.art.first.usersservice.model.dao;

import com.mmi.art.first.usersservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {

  @Override
  Optional<User> findById(Long userId);
}
