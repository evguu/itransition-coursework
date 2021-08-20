package org.litnine.coursework.repositories;

import org.litnine.coursework.domain.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
}