package org.example.proxibanque_achraf_chawki.infrastructure.mapper;

import org.example.proxibanque_achraf_chawki.domain.model.CompteBancaire;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CompteBancaireJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface CompteBancaireMapper {
    CompteBancaire toDomain(CompteBancaireJpaEntity entity);
    CompteBancaireJpaEntity toJpaEntity(CompteBancaire compteBancaire);
}
