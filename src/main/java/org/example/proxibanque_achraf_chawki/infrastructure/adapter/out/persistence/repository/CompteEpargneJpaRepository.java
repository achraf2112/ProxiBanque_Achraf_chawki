package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository;

import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CompteEpargneJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteEpargneJpaRepository extends JpaRepository<CompteEpargneJpaEntity, Long> {
}
