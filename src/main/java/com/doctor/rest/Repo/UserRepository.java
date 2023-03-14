package com.doctor.rest.Repo;

import com.doctor.rest.Models.ProcedimentosRealizados;
import com.doctor.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
