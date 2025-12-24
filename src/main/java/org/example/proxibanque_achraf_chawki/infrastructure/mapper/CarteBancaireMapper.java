package org.example.proxibanque_achraf_chawki.infrastructure.mapper;


import org.example.proxibanque_achraf_chawki.domain.model.CarteBancaire;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CarteBancaireJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface CarteBancaireMapper {
    CarteBancaire toDomain(CarteBancaireJpaEntity entity);
    CarteBancaireJpaEntity toJpaEntity(CarteBancaire carteBancaire);
}
