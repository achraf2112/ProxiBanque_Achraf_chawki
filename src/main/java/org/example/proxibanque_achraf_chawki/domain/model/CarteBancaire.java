package org.example.proxibanque_achraf_chawki.domain.model;

import lombok.Data;
import org.example.proxibanque_achraf_chawki.domain.model.enums.TypeCarte;

@Data
public class CarteBancaire {


    private Long id;

    private String numeroCarte;

    private TypeCarte typeCarte;

    private Boolean active = true;

    private Client client;
}
