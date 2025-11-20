package org.example.proxibanque_achraf_chawki.service;

import org.example.proxibanque_achraf_chawki.entities.Conseiller;

public interface ConseillerService {
    Conseiller createConseiller(Conseiller c);
    Conseiller getConseiller(Long id);
    void assignClient(Long conseillerId, Long clientId);
}
