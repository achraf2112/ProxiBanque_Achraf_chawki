package org.example.proxibanque_achraf_chawki.domain.model;


import lombok.Data;
import org.example.proxibanque_achraf_chawki.entities.CompteBancaire;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Virement {

    private Long id;

    private org.example.proxibanque_achraf_chawki.entities.CompteBancaire compteSource;

    private CompteBancaire compteDestination;

    private BigDecimal montant;

    private String motif;

    private LocalDateTime date;
}
