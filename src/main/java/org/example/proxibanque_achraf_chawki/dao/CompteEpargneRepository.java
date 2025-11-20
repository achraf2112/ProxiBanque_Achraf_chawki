package org.example.proxibanque_achraf_chawki.dao;

import org.example.proxibanque_achraf_chawki.entities.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteEpargneRepository extends JpaRepository<CompteEpargne, Long> {
}
