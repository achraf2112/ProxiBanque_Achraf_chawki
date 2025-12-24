package org.example.proxibanque_achraf_chawki.domain.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Conseiller {

    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String telephone;

    private Agence agence;

    private List<Client> clients = new ArrayList<>();
}
