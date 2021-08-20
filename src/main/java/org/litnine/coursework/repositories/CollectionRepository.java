package org.litnine.coursework.repositories;

import org.litnine.coursework.domain.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CollectionRepository extends JpaRepository<Collection, Long> {
}
