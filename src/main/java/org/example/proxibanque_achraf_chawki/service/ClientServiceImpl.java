package org.example.proxibanque_achraf_chawki.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.dao.*;
import org.example.proxibanque_achraf_chawki.dto.ClientDTO;
import org.example.proxibanque_achraf_chawki.entities.Client;
import org.example.proxibanque_achraf_chawki.entities.Conseiller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ConseillerRepository conseillerRepository;
    private final CompteCourantRepository compteCourantRepository;
    private final CompteEpargneRepository compteEpargneRepository;
    private final CarteBancaireRepository carteRepository;

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
            Conseiller cons = conseillerRepository.findById(dto.getConseillerId())
                    .orElseThrow(() -> new RuntimeException("Conseiller introuvable"));
            c.setConseiller(cons);
        }

        clientRepository.save(c);
        dto.setId(c.getId());
        return dto;
    }


    @Override
    public ClientDTO getClient(Long id) {
        Client c = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        return new ClientDTO(c.getId(), c.getNom(), c.getPrenom(), c.getAdresse(),
                c.getCodePostal(), c.getVille(), c.getTelephone(),
                c.getConseiller() != null ? c.getConseiller().getId() : null);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(c ->
                new ClientDTO(c.getId(), c.getNom(), c.getPrenom(), c.getAdresse(),
                        c.getCodePostal(), c.getVille(), c.getTelephone(),
                        c.getConseiller() != null ? c.getConseiller().getId() : null)
        ).toList();
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO dto) {
        Client c = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client introuvable"));
        c.setNom(dto.getNom());
        c.setPrenom(dto.getPrenom());
        c.setAdresse(dto.getAdresse());
        c.setCodePostal(dto.getCodePostal());
        c.setVille(dto.getVille());
        c.setTelephone(dto.getTelephone());
        clientRepository.save(c);
        return dto;
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        Client c = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client introuvable"));
        // suppression des comptes et cartes via cascade
        clientRepository.delete(c);
    }
}

