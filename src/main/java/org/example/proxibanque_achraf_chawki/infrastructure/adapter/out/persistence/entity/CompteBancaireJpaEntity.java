package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proxibanque_achraf_chawki.entities.Client;

import java.time.LocalDate;

@Entity
@Table(name = "comptes_bancaires")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CompteBancaireJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroCompte;

    @Column(nullable = false)
    private Double solde;

    @Column(nullable = false)
    private LocalDate dateOuverture;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}

