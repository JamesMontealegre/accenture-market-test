package com.accenture_challenge.persistance.crud;

import com.accenture_challenge.persistance.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductCrudRepository extends CrudRepository<Product, Long> {

    @Query(value = """
                SELECT p.* FROM franchises.products p
                INNER JOIN franchises.branches b ON p.branch_id = b.id
                WHERE b.franchise_id = :franchiseId
                AND p.stock = (
                    SELECT MAX(p2.stock)
                    FROM franchises.products p2
                    WHERE p2.branch_id = p.branch_id
                )
            """, nativeQuery = true)
    List<Product> findTopStockedProductsByFranchise(@Param("franchiseId") Long franchiseId);
}
