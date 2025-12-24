package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository;

import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.GerantJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerantJpaRepository extends JpaRepository<GerantJpaEntity, Long> {
}