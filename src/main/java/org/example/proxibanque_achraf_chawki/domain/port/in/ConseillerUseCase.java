package org.example.proxibanque_achraf_chawki.domain.port.in;

import org.example.proxibanque_achraf_chawki.domain.model.Conseiller;

public interface ConseillerUseCase {
    Conseiller createConseiller(Conseiller conseiller);
    Conseiller getConseiller(Long id);
    void assignClient(Long conseillerId, Long clientId);
}
