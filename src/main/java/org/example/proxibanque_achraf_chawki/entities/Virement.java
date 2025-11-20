package org.example.proxibanque_achraf_chawki.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Virement {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private CompteBancaire compteSource;
    @ManyToOne private CompteBancaire compteDestination;
    private BigDecimal montant;
    private String motif;
    private LocalDateTime date;
}

