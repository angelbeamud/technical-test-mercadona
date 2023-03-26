package com.mercadona.mercadona.repository;

import com.mercadona.mercadona.model.Destiny;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface DestinyRepository extends JpaRepository<Destiny, Long> {
}
