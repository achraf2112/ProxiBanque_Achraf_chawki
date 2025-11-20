package org.example.proxibanque_achraf_chawki.service;

import org.example.proxibanque_achraf_chawki.entities.CompteBancaire;
import org.example.proxibanque_achraf_chawki.entities.CompteCourant;
import org.example.proxibanque_achraf_chawki.entities.CompteEpargne;

public interface CompteService {
    CompteCourant createCompteCourant(Long clientId);
    CompteEpargne createCompteEpargne(Long clientId);
    CompteBancaire getCompte(Long id);
    void deleteCompte(Long id);
}
