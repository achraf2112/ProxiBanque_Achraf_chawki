package org.example.proxibanque_achraf_chawki.infrastructure.mapper;

import org.example.proxibanque_achraf_chawki.domain.model.Conseiller;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.ConseillerJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AgenceMapper.class})
public interface ConseillerMapper {
    Conseiller toDomain(ConseillerJpaEntity entity);
    ConseillerJpaEntity toJpaEntity(Conseiller conseiller);
}
