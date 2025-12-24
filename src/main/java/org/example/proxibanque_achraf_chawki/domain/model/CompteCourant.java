package org.example.proxibanque_achraf_chawki.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompteCourant extends CompteBancaire {

    private Double autorisationDecouvert = 1000.0;

    private Client client;
}
