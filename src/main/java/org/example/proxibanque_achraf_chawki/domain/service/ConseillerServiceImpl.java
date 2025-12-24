package org.example.proxibanque_achraf_chawki.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.domain.model.Client;
import org.example.proxibanque_achraf_chawki.domain.model.Conseiller;
import org.example.proxibanque_achraf_chawki.domain.port.in.ConseillerUseCase;
import org.example.proxibanque_achraf_chawki.domain.port.out.ClientRepositoryPort;
import org.example.proxibanque_achraf_chawki.domain.port.out.ConseillerRepositoryPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements ConseillerUseCase {

    private final ConseillerRepositoryPort conseillerRepositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;

    @Override
    public Conseiller createConseiller(Conseiller conseiller) {
        return conseillerRepositoryPort.save(conseiller);
    }

    @Override
    public Conseiller getConseiller(Long id) {
        return conseillerRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Conseiller introuvable"));
    }

    @Override
    @Transactional
    public void assignClient(Long conseillerId, Long clientId) {
        Conseiller conseiller = conseillerRepositoryPort.findById(conseillerId)
                .orElseThrow(() -> new RuntimeException("Conseiller introuvable"));
        Client client = clientRepositoryPort.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        if (conseiller.getClients().size() >= 10) {
            throw new RuntimeException("Le conseiller a déjà 10 clients maximum");
        }

        client.setConseiller(conseiller);
        conseiller.getClients().add(client);

        clientRepositoryPort.save(client);
        conseillerRepositoryPort.save(conseiller);
    }
}
