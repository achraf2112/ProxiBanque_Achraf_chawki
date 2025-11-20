package org.example.proxibanque_achraf_chawki.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.dao.ClientRepository;
import org.example.proxibanque_achraf_chawki.dao.ConseillerRepository;
import org.example.proxibanque_achraf_chawki.entities.Client;
import org.example.proxibanque_achraf_chawki.entities.Conseiller;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements ConseillerService {

    private final ConseillerRepository conseillerRepository;
    private final ClientRepository clientRepository;

    @Override
    public Conseiller createConseiller(Conseiller conseiller) {
        return conseillerRepository.save(conseiller);
    }

    @Override
    public Conseiller getConseiller(Long id) {
        return conseillerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conseiller introuvable"));
    }

    @Override
    @Transactional
    public void assignClient(Long conseillerId, Long clientId) {
        Conseiller conseiller = conseillerRepository.findById(conseillerId)
                .orElseThrow(() -> new RuntimeException("Conseiller introuvable"));
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        if (conseiller.getClients().size() >= 10) {
            throw new RuntimeException("Le conseiller a déjà 10 clients maximum");
        }

        client.setConseiller(conseiller);
        conseiller.getClients().add(client);

        clientRepository.save(client);
        conseillerRepository.save(conseiller);
    }
}

