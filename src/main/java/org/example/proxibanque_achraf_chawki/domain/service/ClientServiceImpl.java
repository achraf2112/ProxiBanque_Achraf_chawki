package org.example.proxibanque_achraf_chawki.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.application.dto.ClientDTO;
import org.example.proxibanque_achraf_chawki.domain.model.Client;
import org.example.proxibanque_achraf_chawki.domain.model.Conseiller;
import org.example.proxibanque_achraf_chawki.domain.port.in.ClientUseCase;
import org.example.proxibanque_achraf_chawki.domain.port.out.ClientRepositoryPort;
import org.example.proxibanque_achraf_chawki.domain.port.out.ConseillerRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;
    private final ConseillerRepositoryPort conseillerRepositoryPort;

    @Override
    public ClientDTO createClient(ClientDTO dto) {
        Client c = new Client();
        c.setNom(dto.getNom());
        c.setPrenom(dto.getPrenom());
        c.setAdresse(dto.getAdresse());
        c.setCodePostal(dto.getCodePostal());
        c.setVille(dto.getVille());
        c.setTelephone(dto.getTelephone());

        if (dto.getConseillerId() != null) {
            Conseiller cons = conseillerRepositoryPort.findById(dto.getConseillerId())
                    .orElseThrow(() -> new RuntimeException("Conseiller introuvable"));
            c.setConseiller(cons);
        }

        Client saved = clientRepositoryPort.save(c);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public ClientDTO getClient(Long id) {
        Client c = clientRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        return toDto(c);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepositoryPort.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO dto) {
        Client c = clientRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        c.setNom(dto.getNom());
        c.setPrenom(dto.getPrenom());
        c.setAdresse(dto.getAdresse());
        c.setCodePostal(dto.getCodePostal());
        c.setVille(dto.getVille());
        c.setTelephone(dto.getTelephone());

        clientRepositoryPort.save(c);
        return dto;
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        clientRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        clientRepositoryPort.deleteById(id);
    }

    private ClientDTO toDto(Client c) {
        return new ClientDTO(
                c.getId(),
                c.getNom(),
                c.getPrenom(),
                c.getAdresse(),
                c.getCodePostal(),
                c.getVille(),
                c.getTelephone(),
                c.getConseiller() != null ? c.getConseiller().getId() : null
        );
    }
}