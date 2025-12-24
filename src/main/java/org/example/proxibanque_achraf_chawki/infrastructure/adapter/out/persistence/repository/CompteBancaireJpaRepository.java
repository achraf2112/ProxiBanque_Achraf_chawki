package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository;

import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CompteBancaireJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompteBancaireJpaRepository extends JpaRepository<CompteBancaireJpaEntity, Long> {
    Optional<CompteBancaireJpaEntity> findByNumeroCompte(String numeroCompte);
    List<CompteBancaireJpaEntity> findByClientId(Long clientId);
}
