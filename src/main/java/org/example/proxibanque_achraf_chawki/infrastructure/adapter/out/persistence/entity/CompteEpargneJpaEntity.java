package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.proxibanque_achraf_chawki.entities.Client;
import org.example.proxibanque_achraf_chawki.entities.CompteBancaire;

@Entity
@DiscriminatorValue("EPARGNE")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CompteEpargneJpaEntity extends CompteBancaireJpaEntity {

    private Double tauxRemuneration = 3.0;

    @OneToOne
    private Client client;
}
