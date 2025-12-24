package org.example.proxibanque_achraf_chawki.domain.port.out;

import org.example.proxibanque_achraf_chawki.domain.model.Virement;

import java.util.List;
import java.util.Optional;

public interface VirementRepositoryPort {
    Virement save(Virement virement);
    Optional<Virement> findById(Long id);
    List<Virement> findAll();
    void deleteById(Long id);
}
