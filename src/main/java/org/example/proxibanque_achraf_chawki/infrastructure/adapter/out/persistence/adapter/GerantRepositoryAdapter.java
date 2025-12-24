package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.adapter;

import org.example.proxibanque_achraf_chawki.domain.model.Gerant;
import org.example.proxibanque_achraf_chawki.domain.port.out.GerantRepositoryPort;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.GerantJpaEntity;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository.GerantJpaRepository;
import org.example.proxibanque_achraf_chawki.infrastructure.mapper.GerantMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GerantRepositoryAdapter implements GerantRepositoryPort {

    private final GerantJpaRepository jpaRepository;
    private final GerantMapper mapper;

    public GerantRepositoryAdapter(GerantJpaRepository jpaRepository, GerantMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Gerant save(Gerant gerant) {
        GerantJpaEntity entity = mapper.toJpaEntity(gerant);
        GerantJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Gerant> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Gerant> findAll() {
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
