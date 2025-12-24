package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.adapter;

import org.example.proxibanque_achraf_chawki.domain.model.Client;
import org.example.proxibanque_achraf_chawki.domain.port.out.ClientRepositoryPort;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.ClientJpaEntity;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository.ClientJpaRepository;
import org.example.proxibanque_achraf_chawki.infrastructure.mapper.ClientMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final ClientJpaRepository jpaRepository;
    private final ClientMapper mapper;

    public ClientRepositoryAdapter(ClientJpaRepository jpaRepository, ClientMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Client save(Client client) {
        ClientJpaEntity entity = mapper.toJpaEntity(client);
        ClientJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Client> findByConseillerId(Long conseillerId) {
        return jpaRepository.findByConseillerId(conseillerId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Client> findByAgenceNumero(String numeroAgence) {
        return jpaRepository.findByAgenceNumero(numeroAgence)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
