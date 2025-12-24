package org.example.proxibanque_achraf_chawki.infrastructure.mapper;

import org.example.proxibanque_achraf_chawki.domain.model.Virement;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.VirementJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CompteBancaireMapper.class})
public interface VirementMapper {
    Virement toDomain(VirementJpaEntity entity);
    VirementJpaEntity toJpaEntity(Virement virement);
}
