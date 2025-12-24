package org.example.proxibanque_achraf_chawki.domain.port.out;

import org.example.proxibanque_achraf_chawki.domain.model.CompteEpargne;

import java.util.List;
import java.util.Optional;

public interface CompteEpargneRepositoryPort {
    CompteEpargne save(CompteEpargne compteEpargne);
    Optional<CompteEpargne> findById(Long id);
    List<CompteEpargne> findAll();
    void deleteById(Long id);
}

