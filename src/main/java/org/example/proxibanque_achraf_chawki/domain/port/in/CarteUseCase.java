package org.example.proxibanque_achraf_chawki.domain.port.in;

import org.example.proxibanque_achraf_chawki.domain.model.CarteBancaire;
import org.example.proxibanque_achraf_chawki.domain.model.enums.TypeCarte;

public interface CarteUseCase {
    CarteBancaire createCarte(Long clientId, TypeCarte type);
    void desactiverCarte(Long carteId);
}
