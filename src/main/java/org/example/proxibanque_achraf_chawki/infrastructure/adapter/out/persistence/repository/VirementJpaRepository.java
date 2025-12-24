package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository;

import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.VirementJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementJpaRepository extends JpaRepository<VirementJpaEntity, Long> {
}