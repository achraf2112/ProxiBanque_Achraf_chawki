package org.example.proxibanque_achraf_chawki.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proxibanque_achraf_chawki.enums.TypeCarte;

@Entity
@Table(name = "cartes_bancaires")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarteBancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroCarte;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeCarte typeCarte;

    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
