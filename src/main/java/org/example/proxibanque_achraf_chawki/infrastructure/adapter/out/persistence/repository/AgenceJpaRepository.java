package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository;

import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.AgenceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenceJpaRepository extends JpaRepository<AgenceJpaEntity, Integer> {
    Optional<AgenceJpaEntity> findByNumeroIdentification(String numeroAgence);
}
