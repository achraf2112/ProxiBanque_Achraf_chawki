package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.adapter;

import org.example.proxibanque_achraf_chawki.domain.model.Conseiller;
import org.example.proxibanque_achraf_chawki.domain.port.out.ConseillerRepositoryPort;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.ConseillerJpaEntity;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository.ConseillerJpaRepository;
import org.example.proxibanque_achraf_chawki.infrastructure.mapper.ConseillerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConseillerRepositoryAdapter implements ConseillerRepositoryPort {

    private final ConseillerJpaRepository jpaRepository;
    private final ConseillerMapper mapper;

    public ConseillerRepositoryAdapter(ConseillerJpaRepository jpaRepository, ConseillerMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Conseiller save(Conseiller conseiller) {
        ConseillerJpaEntity entity = mapper.toJpaEntity(conseiller);
        ConseillerJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Conseiller> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Conseiller> findAll() {
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
