package org.litnine.coursework.repositories;

import org.litnine.coursework.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Long> {
}