package com.khaled.tms.Repo;

import com.khaled.tms.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity>  findByUsername(String username);
    public UserEntity findByEmail(String email);
    boolean existsByUsername(String username);

}
