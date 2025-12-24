package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository;

import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CompteCourantJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteCourantJpaRepository extends JpaRepository<CompteCourantJpaEntity, Long> {
}
