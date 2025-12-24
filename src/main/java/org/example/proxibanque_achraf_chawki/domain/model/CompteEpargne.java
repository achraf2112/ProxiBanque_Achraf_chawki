package org.example.proxibanque_achraf_chawki.domain.model;

import lombok.Data;

@Data
public class CompteEpargne extends CompteBancaire {

    private Double tauxRemuneration = 3.0;

    private Client client;
}
