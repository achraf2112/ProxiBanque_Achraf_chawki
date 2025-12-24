package org.example.proxibanque_achraf_chawki.domain.port.out;


import org.example.proxibanque_achraf_chawki.domain.model.CompteCourant;

import java.util.List;
import java.util.Optional;

public interface CompteCourantRepositoryPort {
    CompteCourant save(CompteCourant compteCourant);
    Optional<CompteCourant> findById(Long id);
    List<CompteCourant> findAll();
    void deleteById(Long id);
}
