package org.litnine.coursework.repositories;

import org.litnine.coursework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(String id);
}
