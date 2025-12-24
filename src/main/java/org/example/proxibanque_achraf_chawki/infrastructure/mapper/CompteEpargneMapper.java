package org.example.proxibanque_achraf_chawki.infrastructure.mapper;

import org.example.proxibanque_achraf_chawki.domain.model.CompteEpargne;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CompteEpargneJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface CompteEpargneMapper {
    CompteEpargne toDomain(CompteEpargneJpaEntity entity);
    CompteEpargneJpaEntity toJpaEntity(CompteEpargne compteEpargne);
}
