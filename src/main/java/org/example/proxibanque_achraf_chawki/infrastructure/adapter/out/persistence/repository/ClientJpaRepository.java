package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository;

import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.ClientJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientJpaRepository extends JpaRepository<ClientJpaEntity, Long> {

    List<ClientJpaEntity> findByConseillerId(Long conseillerId);

    @Query("SELECT c FROM ClientJpaEntity c WHERE c.conseiller.agence.numeroIdentification = :numeroAgence")
    List<ClientJpaEntity> findByAgenceNumero(@Param("numeroAgence") String numeroAgence);
}
