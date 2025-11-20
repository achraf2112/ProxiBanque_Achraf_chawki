package org.example.proxibanque_achraf_chawki.service;

import org.example.proxibanque_achraf_chawki.dto.ClientDTO;
import org.example.proxibanque_achraf_chawki.entities.Client;

import java.util.List;

public interface ClientService {
    ClientDTO createClient(ClientDTO dto);
    ClientDTO getClient(Long id);
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(Long id, ClientDTO dto);
    void deleteClient(Long id);
}
