package org.example.proxibanque_achraf_chawki.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proxibanque_achraf_chawki.entities.Agence;
import org.example.proxibanque_achraf_chawki.entities.Client;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conseillers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConseillerJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String email;

    private String telephone;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<>();
}
