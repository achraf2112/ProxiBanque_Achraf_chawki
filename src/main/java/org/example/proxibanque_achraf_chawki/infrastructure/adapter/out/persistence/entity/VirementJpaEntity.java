package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proxibanque_achraf_chawki.entities.CompteBancaire;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VirementJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private org.example.proxibanque_achraf_chawki.entities.CompteBancaire compteSource;
    @ManyToOne private CompteBancaire compteDestination;
    private BigDecimal montant;
    private String motif;
    private LocalDateTime date;
}

