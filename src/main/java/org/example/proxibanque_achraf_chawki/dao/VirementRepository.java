package org.example.proxibanque_achraf_chawki.dao;

import org.example.proxibanque_achraf_chawki.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementRepository extends JpaRepository<Virement, Long> {
}
