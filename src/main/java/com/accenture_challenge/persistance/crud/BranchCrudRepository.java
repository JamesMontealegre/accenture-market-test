package com.accenture_challenge.persistance.crud;

import com.accenture_challenge.persistance.entity.Branch;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BranchCrudRepository extends CrudRepository<Branch, Long> {

    List<Branch> findByFranchiseId(Long franchiseId);
}
