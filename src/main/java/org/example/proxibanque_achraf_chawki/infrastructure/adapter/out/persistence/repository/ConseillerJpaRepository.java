package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository;

import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.ConseillerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConseillerJpaRepository extends JpaRepository<ConseillerJpaEntity, Long> {
}
