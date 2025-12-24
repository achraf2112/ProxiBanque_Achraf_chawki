package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.adapter;

import org.example.proxibanque_achraf_chawki.domain.model.CompteEpargne;
import org.example.proxibanque_achraf_chawki.domain.port.out.CompteEpargneRepositoryPort;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CompteEpargneJpaEntity;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository.CompteEpargneJpaRepository;
import org.example.proxibanque_achraf_chawki.infrastructure.mapper.CompteEpargneMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompteEpargneRepositoryAdapter implements CompteEpargneRepositoryPort {

    private final CompteEpargneJpaRepository jpaRepository;
    private final CompteEpargneMapper mapper;

    public CompteEpargneRepositoryAdapter(CompteEpargneJpaRepository jpaRepository, CompteEpargneMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public CompteEpargne save(CompteEpargne compteEpargne) {
        CompteEpargneJpaEntity entity = mapper.toJpaEntity(compteEpargne);
        CompteEpargneJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CompteEpargne> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<CompteEpargne> findAll() {
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
