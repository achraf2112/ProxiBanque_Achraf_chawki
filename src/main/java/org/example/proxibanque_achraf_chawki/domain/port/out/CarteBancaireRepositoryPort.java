package org.example.proxibanque_achraf_chawki.domain.port.out;

import org.example.proxibanque_achraf_chawki.domain.model.CarteBancaire;

import java.util.List;
import java.util.Optional;

public interface CarteBancaireRepositoryPort {
    CarteBancaire save(CarteBancaire carteBancaire);
    Optional<CarteBancaire> findById(Long id);
    List<CarteBancaire> findAll();
    void deleteById(Long id);
    List<CarteBancaire> findByClientId(Long clientId);
    List<CarteBancaire> findByClientIdAndActiveTrue(Long clientId);
}
