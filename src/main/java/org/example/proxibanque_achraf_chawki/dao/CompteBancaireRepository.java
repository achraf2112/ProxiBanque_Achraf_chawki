package org.example.proxibanque_achraf_chawki.dao;

import org.example.proxibanque_achraf_chawki.entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {
    Optional<CompteBancaire> findByNumeroCompte(String numeroCompte);
    List<CompteBancaire> findByClientId(Long clientId);
}
