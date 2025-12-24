package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.adapter;

import org.example.proxibanque_achraf_chawki.domain.model.Agence;
import org.example.proxibanque_achraf_chawki.domain.port.out.AgenceRepositoryPort;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.AgenceJpaEntity;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository.AgenceJpaRepository;
import org.example.proxibanque_achraf_chawki.infrastructure.mapper.AgenceMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AgenceRepositoryAdapter implements AgenceRepositoryPort {

    private final AgenceJpaRepository jpaRepository;
    private final AgenceMapper mapper;

    public AgenceRepositoryAdapter(AgenceJpaRepository jpaRepository, AgenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Agence save(Agence agence) {
        AgenceJpaEntity entity = mapper.toJpaEntity(agence);
        AgenceJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Agence> findById(Integer id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Agence> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<Agence> findByNumeroIdentification(String numeroAgence) {
        return jpaRepository.findByNumeroIdentification(numeroAgence)
                .map(mapper::toDomain);
    }
}
