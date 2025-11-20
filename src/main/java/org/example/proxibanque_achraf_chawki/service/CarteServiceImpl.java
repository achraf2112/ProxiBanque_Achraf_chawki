package org.example.proxibanque_achraf_chawki.service;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.dao.CarteBancaireRepository;
import org.example.proxibanque_achraf_chawki.dao.ClientRepository;
import org.example.proxibanque_achraf_chawki.entities.CarteBancaire;
import org.example.proxibanque_achraf_chawki.entities.Client;
import org.example.proxibanque_achraf_chawki.enums.TypeCarte;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarteServiceImpl implements CarteService {

    private final ClientRepository clientRepository;
    private final CarteBancaireRepository carteRepository;

    @Override
    public CarteBancaire createCarte(Long clientId, TypeCarte type) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        CarteBancaire carte = new CarteBancaire();
        carte.setClient(client);
        carte.setTypeCarte(type);
        carte.setActive(true);
        carte.setNumeroCarte(generateNumeroCarte());

        return carteRepository.save(carte);
    }

    @Override
    public void desactiverCarte(Long carteId) {
        CarteBancaire carte = carteRepository.findById(carteId)
                .orElseThrow(() -> new RuntimeException("Carte introuvable"));
        carte.setActive(false);
        carteRepository.save(carte);
    }

    // Génération simple d’un numéro de carte aléatoire
    private String generateNumeroCarte() {
        return "CB" + (int)(Math.random() * 1_0000_0000);
    }
}

