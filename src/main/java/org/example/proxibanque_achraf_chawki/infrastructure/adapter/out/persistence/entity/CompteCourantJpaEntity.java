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
@DiscriminatorValue("COURANT")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CompteCourantJpaEntity extends CompteBancaireJpaEntity {

    private Double autorisationDecouvert = 1000.0;

    @OneToOne
    private Client client;
}

