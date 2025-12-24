package org.example.proxibanque_achraf_chawki.domain.port.out;


import org.example.proxibanque_achraf_chawki.domain.model.Conseiller;

import java.util.List;
import java.util.Optional;

public interface ConseillerRepositoryPort {
    Conseiller save(Conseiller conseiller);
    Optional<Conseiller> findById(Long id);
    List<Conseiller> findAll();
    void deleteById(Long id);
}