package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository;

import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CarteBancaireJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarteBancaireJpaRepository extends JpaRepository<CarteBancaireJpaEntity, Long> {
    List<CarteBancaireJpaEntity> findByClientId(Long clientId);
    List<CarteBancaireJpaEntity> findByClientIdAndActiveTrue(Long clientId);
}