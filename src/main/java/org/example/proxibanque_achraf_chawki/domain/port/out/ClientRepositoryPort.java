package org.example.proxibanque_achraf_chawki.domain.port.out;

import org.example.proxibanque_achraf_chawki.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {
    Client save(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAll();
    void deleteById(Long id);
    List<Client> findByConseillerId(Long conseillerId);
    List<Client> findByAgenceNumero(String numeroAgence);
}
