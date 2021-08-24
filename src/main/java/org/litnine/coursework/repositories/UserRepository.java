package org.litnine.coursework.repositories;

import org.litnine.coursework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, String> {
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        @Override
        void deleteById(String id);

        @PreAuthorize("hasRole('ROLE_ADMIN')")
        @Override
        void delete(User user);

        @Override
        Optional<User> findById(String id);
}
