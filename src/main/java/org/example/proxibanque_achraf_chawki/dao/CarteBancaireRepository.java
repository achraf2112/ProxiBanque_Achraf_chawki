package org.example.proxibanque_achraf_chawki.dao;

import org.example.proxibanque_achraf_chawki.entities.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteBancaireRepository extends JpaRepository<CarteBancaire, Long> {
    List<CarteBancaire> findByClientId(Long clientId);
    List<CarteBancaire> findByClientIdAndActiveTrue(Long clientId);
}
