package org.example.proxibanque_achraf_chawki.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.dao.ClientRepository;
import org.example.proxibanque_achraf_chawki.dao.CompteBancaireRepository;
import org.example.proxibanque_achraf_chawki.dao.CompteCourantRepository;
import org.example.proxibanque_achraf_chawki.dao.CompteEpargneRepository;
import org.example.proxibanque_achraf_chawki.entities.Client;
import org.example.proxibanque_achraf_chawki.entities.CompteBancaire;
import org.example.proxibanque_achraf_chawki.entities.CompteCourant;
import org.example.proxibanque_achraf_chawki.entities.CompteEpargne;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {

    private final ClientRepository clientRepository;
    private final CompteCourantRepository compteCourantRepository;
    private final CompteEpargneRepository compteEpargneRepository;
    private final CompteBancaireRepository compteBancaireRepository;

    @Override
    public CompteCourant createCompteCourant(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        if (client.getCompteCourant() != null) {
            throw new RuntimeException("Le client possède déjà un compte courant");
        }

        CompteCourant compte = new CompteCourant();
        compte.setClient(client);
        compte.setSolde(0.0);
        compte.setNumeroCompte(generateNumeroCompte());
        compte.setDateOuverture(LocalDate.now());
        compte.setAutorisationDecouvert(1000.0);

        client.setCompteCourant(compte);

        compteCourantRepository.save(compte);
        clientRepository.save(client);

        return compte;
    }

    @Override
    public CompteEpargne createCompteEpargne(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        if (client.getCompteEpargne() != null) {
            throw new RuntimeException("Le client possède déjà un compte épargne");
        }

        CompteEpargne compte = new CompteEpargne();
        compte.setClient(client);
        compte.setSolde(0.0);
        compte.setNumeroCompte(generateNumeroCompte());
        compte.setDateOuverture(LocalDate.now());
        compte.setTauxRemuneration(3.0);

        client.setCompteEpargne(compte);

        compteEpargneRepository.save(compte);
        clientRepository.save(client);

        return compte;
    }

    @Override
    public CompteBancaire getCompte(Long id) {
        return compteBancaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }

    @Override
    @Transactional
    public void deleteCompte(Long id) {
        CompteBancaire compte = compteBancaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));

        Client client = compte.getClient();
        if (compte instanceof CompteCourant) {
            client.setCompteCourant(null);
        } else if (compte instanceof CompteEpargne) {
            client.setCompteEpargne(null);
        }

        clientRepository.save(client);
        compteBancaireRepository.delete(compte);
    }

    private String generateNumeroCompte() {
        return "ACC" + (int)(Math.random() * 1_0000_0000);
    }
}

