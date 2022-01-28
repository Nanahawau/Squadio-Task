package com.squadio.accountstatements.repositories;

import com.squadio.accountstatements.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserNameIgnoreCase(String username);


}
