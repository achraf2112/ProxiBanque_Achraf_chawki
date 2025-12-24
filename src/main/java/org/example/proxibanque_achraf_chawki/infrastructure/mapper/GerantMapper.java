package org.example.proxibanque_achraf_chawki.infrastructure.mapper;

import org.example.proxibanque_achraf_chawki.domain.model.Gerant;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.GerantJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AgenceMapper.class})
public interface GerantMapper {
    Gerant toDomain(GerantJpaEntity entity);
    GerantJpaEntity toJpaEntity(Gerant gerant);
}
