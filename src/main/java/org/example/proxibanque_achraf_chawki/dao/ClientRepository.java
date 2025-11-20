package org.example.proxibanque_achraf_chawki.dao;

import org.example.proxibanque_achraf_chawki.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByConseillerId(Long conseillerId);
    @Query("SELECT c FROM Client c WHERE c.conseiller.agence.numeroIdentification = :numeroAgence")
    List<Client> findByAgenceId(@Param("numeroAgence") String numeroAgence);
}