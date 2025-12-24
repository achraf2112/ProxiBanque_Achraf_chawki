package org.example.proxibanque_achraf_chawki.domain.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Client {

    private Long id;

    private String nom;

    private String prenom;

    private String adresse;

    private String codePostal;

    private String ville;

    private String telephone;

    private Conseiller conseiller;

    private CompteCourant compteCourant;

    private CompteEpargne compteEpargne;

    private List<CarteBancaire> cartesBancaires = new ArrayList<>();

    public boolean isClientFortune() {
        double totalSolde = 0.0;
        if (compteCourant != null) {
            totalSolde += compteCourant.getSolde();
        }
        if (compteEpargne != null) {
            totalSolde += compteEpargne.getSolde();
        }
        return totalSolde > 500000.0;
    }
}
