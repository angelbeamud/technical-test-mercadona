package com.mercadona.mercadona.repository;

import com.mercadona.mercadona.model.Supplier;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByReferenceCode(Long referenceCode);
}
