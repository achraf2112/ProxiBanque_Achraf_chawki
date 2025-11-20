package org.example.proxibanque_achraf_chawki.service;

import org.example.proxibanque_achraf_chawki.entities.CarteBancaire;
import org.example.proxibanque_achraf_chawki.enums.TypeCarte;

public interface CarteService {
    CarteBancaire createCarte(Long clientId, TypeCarte type);
    void desactiverCarte(Long carteId);
}
