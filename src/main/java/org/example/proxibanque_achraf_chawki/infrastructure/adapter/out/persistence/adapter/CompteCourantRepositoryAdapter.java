package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.adapter;

import org.example.proxibanque_achraf_chawki.domain.model.CompteCourant;
import org.example.proxibanque_achraf_chawki.domain.port.out.CompteCourantRepositoryPort;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CompteCourantJpaEntity;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository.CompteCourantJpaRepository;
import org.example.proxibanque_achraf_chawki.infrastructure.mapper.CompteCourantMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompteCourantRepositoryAdapter implements CompteCourantRepositoryPort {

    private final CompteCourantJpaRepository jpaRepository;
    private final CompteCourantMapper mapper;

    public CompteCourantRepositoryAdapter(CompteCourantJpaRepository jpaRepository, CompteCourantMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public CompteCourant save(CompteCourant compteCourant) {
        CompteCourantJpaEntity entity = mapper.toJpaEntity(compteCourant);
        CompteCourantJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CompteCourant> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<CompteCourant> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
