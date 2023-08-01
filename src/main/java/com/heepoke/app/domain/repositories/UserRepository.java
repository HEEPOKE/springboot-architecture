package com.heepoke.app.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.heepoke.app.domain.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}