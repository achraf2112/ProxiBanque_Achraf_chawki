package org.example.proxibanque_achraf_chawki.domain.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public abstract class CompteBancaire {

    private Long id;

    private String numeroCompte;

    private Double solde;

    private LocalDate dateOuverture;

    private Client client;
}
