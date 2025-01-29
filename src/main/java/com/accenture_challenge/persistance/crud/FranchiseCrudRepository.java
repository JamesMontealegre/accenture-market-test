package com.accenture_challenge.persistance.crud;

import com.accenture_challenge.persistance.entity.Franchise;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FranchiseCrudRepository extends CrudRepository<Franchise, Long> {

    Optional<Franchise> findById(Long id);

    Optional<Franchise> findByName(String name);

    boolean existsByName(String name);
}
