package org.example.proxibanque_achraf_chawki.domain.port.out;

import org.example.proxibanque_achraf_chawki.domain.model.CompteBancaire;

import java.util.List;
import java.util.Optional;

public interface CompteBancaireRepositoryPort {
    CompteBancaire save(CompteBancaire compteBancaire);
    Optional<CompteBancaire> findById(Long id);
    List<CompteBancaire> findAll();
    void deleteById(Long id);
    Optional<CompteBancaire> findByNumeroCompte(String numeroCompte);
    List<CompteBancaire> findByClientId(Long clientId);
}
