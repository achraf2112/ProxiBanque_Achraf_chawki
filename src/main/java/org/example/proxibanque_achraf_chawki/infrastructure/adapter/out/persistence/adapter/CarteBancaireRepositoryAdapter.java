package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.adapter;

import org.example.proxibanque_achraf_chawki.domain.model.CarteBancaire;
import org.example.proxibanque_achraf_chawki.domain.port.out.CarteBancaireRepositoryPort;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CarteBancaireJpaEntity;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.repository.CarteBancaireJpaRepository;
import org.example.proxibanque_achraf_chawki.infrastructure.mapper.CarteBancaireMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarteBancaireRepositoryAdapter implements CarteBancaireRepositoryPort {

    private final CarteBancaireJpaRepository jpaRepository;
    private final CarteBancaireMapper mapper;

    public CarteBancaireRepositoryAdapter(CarteBancaireJpaRepository jpaRepository, CarteBancaireMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public CarteBancaire save(CarteBancaire carteBancaire) {
        CarteBancaireJpaEntity entity = mapper.toJpaEntity(carteBancaire);
        CarteBancaireJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CarteBancaire> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<CarteBancaire> findAll() {
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
    public List<CarteBancaire> findByClientId(Long clientId) {
        return jpaRepository.findByClientId(clientId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<CarteBancaire> findByClientIdAndActiveTrue(Long clientId) {
        return jpaRepository.findByClientIdAndActiveTrue(clientId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}