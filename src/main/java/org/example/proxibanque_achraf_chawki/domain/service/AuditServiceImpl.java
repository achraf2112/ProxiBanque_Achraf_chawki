package org.example.proxibanque_achraf_chawki.domain.service;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.application.dto.AuditDTO;
import org.example.proxibanque_achraf_chawki.domain.model.Client;
import org.example.proxibanque_achraf_chawki.domain.port.in.AuditUseCase;
import org.example.proxibanque_achraf_chawki.domain.port.out.ClientRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    @Override
    public AuditDTO auditerAgence(String numeroAgence) {
        List<Client> clients = clientRepositoryPort.findByAgenceNumero(numeroAgence);
        List<String> anomalies = new ArrayList<>();

        for (Client c : clients) {
            if (c.getCompteCourant() != null && c.getCompteCourant().getSolde() < -500)
                anomalies.add(c.getNom() + " débiteur courant > 500€");
            if (c.getCompteEpargne() != null && c.getCompteEpargne().getSolde() < 0)
                anomalies.add(c.getNom() + " compte épargne débiteur");
        }

        return new AuditDTO(numeroAgence, LocalDate.now(), anomalies, clients.size());
    }
}
