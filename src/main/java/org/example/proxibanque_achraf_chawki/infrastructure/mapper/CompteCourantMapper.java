package org.example.proxibanque_achraf_chawki.infrastructure.mapper;


import org.example.proxibanque_achraf_chawki.domain.model.CompteCourant;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.CompteCourantJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface CompteCourantMapper {
    CompteCourant toDomain(CompteCourantJpaEntity entity);
    CompteCourantJpaEntity toJpaEntity(CompteCourant compteCourant);
}