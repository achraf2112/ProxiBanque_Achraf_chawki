package org.example.proxibanque_achraf_chawki.infrastructure.mapper;

import org.example.proxibanque_achraf_chawki.domain.model.Agence;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.AgenceJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgenceMapper {
    Agence toDomain(AgenceJpaEntity entity);
    AgenceJpaEntity toJpaEntity(Agence agence);
}
