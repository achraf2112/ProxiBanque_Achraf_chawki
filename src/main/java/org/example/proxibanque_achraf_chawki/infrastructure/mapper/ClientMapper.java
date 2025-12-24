package org.example.proxibanque_achraf_chawki.infrastructure.mapper;


import org.example.proxibanque_achraf_chawki.domain.model.Client;
import org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity.ClientJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ConseillerMapper.class})
public interface ClientMapper {
    Client toDomain(ClientJpaEntity entity);
    ClientJpaEntity toJpaEntity(Client client);
}
