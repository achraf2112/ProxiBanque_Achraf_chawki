package org.example.proxibanque_achraf_chawki.domain.port.in;


import org.example.proxibanque_achraf_chawki.application.dto.ClientDTO;

import java.util.List;

public interface ClientUseCase {
    ClientDTO createClient(ClientDTO dto);
    ClientDTO getClient(Long id);
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(Long id, ClientDTO dto);
    void deleteClient(Long id);
}
