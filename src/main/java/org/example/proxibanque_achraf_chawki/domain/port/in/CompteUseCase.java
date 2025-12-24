package org.example.proxibanque_achraf_chawki.domain.port.in;

import org.example.proxibanque_achraf_chawki.domain.model.CompteBancaire;
import org.example.proxibanque_achraf_chawki.domain.model.CompteCourant;
import org.example.proxibanque_achraf_chawki.domain.model.CompteEpargne;

public interface CompteUseCase {
    CompteCourant createCompteCourant(Long clientId);
    CompteEpargne createCompteEpargne(Long clientId);
    CompteBancaire getCompte(Long id);
    void deleteCompte(Long id);
}
