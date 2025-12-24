package org.example.proxibanque_achraf_chawki.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.domain.model.Client;
import org.example.proxibanque_achraf_chawki.domain.model.CompteBancaire;
import org.example.proxibanque_achraf_chawki.domain.model.CompteCourant;
import org.example.proxibanque_achraf_chawki.domain.model.CompteEpargne;
import org.example.proxibanque_achraf_chawki.domain.port.in.CompteUseCase;
import org.example.proxibanque_achraf_chawki.domain.port.out.ClientRepositoryPort;
import org.example.proxibanque_achraf_chawki.domain.port.out.CompteBancaireRepositoryPort;
import org.example.proxibanque_achraf_chawki.domain.port.out.CompteCourantRepositoryPort;
import org.example.proxibanque_achraf_chawki.domain.port.out.CompteEpargneRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteUseCase {

    private final ClientRepositoryPort clientRepositoryPort;
    private final CompteCourantRepositoryPort compteCourantRepositoryPort;
    private final CompteEpargneRepositoryPort compteEpargneRepositoryPort;
    private final CompteBancaireRepositoryPort compteBancaireRepositoryPort;

    @Override
    public CompteCourant createCompteCourant(Long clientId) {
        Client client = clientRepositoryPort.findById(clientId)
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

        CompteCourant saved = compteCourantRepositoryPort.save(compte);
        clientRepositoryPort.save(client);

        return saved;
    }

    @Override
    public CompteEpargne createCompteEpargne(Long clientId) {
        Client client = clientRepositoryPort.findById(clientId)
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

        CompteEpargne saved = compteEpargneRepositoryPort.save(compte);
        clientRepositoryPort.save(client);

        return saved;
    }

    @Override
    public CompteBancaire getCompte(Long id) {
        return compteBancaireRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }

    @Override
    @Transactional
    public void deleteCompte(Long id) {
        CompteBancaire compte = compteBancaireRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));

        Client client = compte.getClient();
        if (compte instanceof CompteCourant) {
            client.setCompteCourant(null);
        } else if (compte instanceof CompteEpargne) {
            client.setCompteEpargne(null);
        }

        clientRepositoryPort.save(client);
        compteBancaireRepositoryPort.deleteById(id);
    }

    private String generateNumeroCompte() {
        return "ACC" + (int)(Math.random() * 1_0000_0000);
    }
}