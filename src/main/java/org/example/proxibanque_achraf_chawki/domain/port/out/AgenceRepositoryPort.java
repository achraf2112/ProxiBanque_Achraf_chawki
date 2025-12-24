package org.example.proxibanque_achraf_chawki.domain.port.out;

import org.example.proxibanque_achraf_chawki.domain.model.Agence;

import java.util.List;
import java.util.Optional;

public interface AgenceRepositoryPort {
    Agence save(Agence agence);
    Optional<Agence> findById(Integer id);
    List<Agence> findAll();
    void deleteById(Integer id);
    Optional<Agence> findByNumeroIdentification(String numeroAgence);
}
