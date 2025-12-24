package org.example.proxibanque_achraf_chawki.domain.port.out;

import org.example.proxibanque_achraf_chawki.domain.model.Gerant;

import java.util.List;
import java.util.Optional;

public interface GerantRepositoryPort {
    Gerant save(Gerant gerant);
    Optional<Gerant> findById(Long id);
    List<Gerant> findAll();
    void deleteById(Long id);
}
