package org.example.proxibanque_achraf_chawki.domain.service;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.domain.model.CarteBancaire;
import org.example.proxibanque_achraf_chawki.domain.model.Client;
import org.example.proxibanque_achraf_chawki.domain.model.enums.TypeCarte;
import org.example.proxibanque_achraf_chawki.domain.port.in.CarteUseCase;
import org.example.proxibanque_achraf_chawki.domain.port.out.CarteBancaireRepositoryPort;
import org.example.proxibanque_achraf_chawki.domain.port.out.ClientRepositoryPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarteServiceImpl implements CarteUseCase {

    private final ClientRepositoryPort clientRepositoryPort;
    private final CarteBancaireRepositoryPort carteRepositoryPort;

    @Override
    public CarteBancaire createCarte(Long clientId, TypeCarte type) {
        Client client = clientRepositoryPort.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        CarteBancaire carte = new CarteBancaire();
        carte.setClient(client);
        carte.setTypeCarte(type);
        carte.setActive(true);
        carte.setNumeroCarte(generateNumeroCarte());

        return carteRepositoryPort.save(carte);
    }


    @Override
    public void desactiverCarte(Long carteId) {
        CarteBancaire carte = carteRepositoryPort.findById(carteId)
                .orElseThrow(() -> new RuntimeException("Carte introuvable"));
        carte.setActive(false);
        carteRepositoryPort.save(carte);
    }

    private String generateNumeroCarte() {
        return "CB" + (int)(Math.random() * 1_0000_0000);
    }
}
