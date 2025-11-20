package org.example.proxibanque_achraf_chawki.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String adresse;

    private String codePostal;

    private String ville;

    private String telephone;

    @ManyToOne
    @JoinColumn(name = "conseiller_id")
    private Conseiller conseiller;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private CompteCourant compteCourant;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private CompteEpargne compteEpargne;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
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
