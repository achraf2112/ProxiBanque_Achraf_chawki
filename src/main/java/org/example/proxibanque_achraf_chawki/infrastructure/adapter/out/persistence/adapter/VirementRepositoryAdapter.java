package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.adapter;

import org.example.proxibanque_achraf_chawki.domain.model.Virement;
import org.example.proxibanque_achraf_chawki.domain.port.out.VirementRepositoryPort;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.VirementJpaEntity;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository.VirementJpaRepository;
import org.example.proxibanque_achraf_chawki.infrastructure.mapper.VirementMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VirementRepositoryAdapter implements VirementRepositoryPort {

    private final VirementJpaRepository jpaRepository;
    private final VirementMapper mapper;

    public VirementRepositoryAdapter(VirementJpaRepository jpaRepository, VirementMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Virement save(Virement virement) {
        VirementJpaEntity entity = mapper.toJpaEntity(virement);
        VirementJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Virement> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Virement> findAll() {
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
