package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.adapter;

import org.example.proxibanque_achraf_chawki.domain.model.CompteBancaire;
import org.example.proxibanque_achraf_chawki.domain.port.out.CompteBancaireRepositoryPort;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CompteBancaireJpaEntity;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository.CompteBancaireJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompteBancaireRepositoryAdapter implements CompteBancaireRepositoryPort {

    private final CompteBancaireJpaRepository jpaRepository;
    private final CompteBancaireMapper mapper;

    public CompteBancaireRepositoryAdapter(CompteBancaireJpaRepository jpaRepository, CompteBancaireMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public CompteBancaire save(CompteBancaire compteBancaire) {
        CompteBancaireJpaEntity entity = mapper.toJpaEntity(compteBancaire);
        CompteBancaireJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CompteBancaire> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<CompteBancaire> findAll() {
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
    public Optional<CompteBancaire> findByNumeroCompte(String numeroCompte) {
        return jpaRepository.findByNumeroCompte(numeroCompte)
                .map(mapper::toDomain);
    }

    @Override
    public List<CompteBancaire> findByClientId(Long clientId) {
        return jpaRepository.findByClientId(clientId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
