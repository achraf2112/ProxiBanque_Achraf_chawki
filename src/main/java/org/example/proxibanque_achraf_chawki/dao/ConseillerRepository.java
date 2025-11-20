package org.example.proxibanque_achraf_chawki.dao;

import org.example.proxibanque_achraf_chawki.entities.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConseillerRepository extends JpaRepository<Conseiller, Long> {}
