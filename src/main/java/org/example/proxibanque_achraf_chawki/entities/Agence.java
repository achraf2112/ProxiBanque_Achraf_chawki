package org.example.proxibanque_achraf_chawki.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @Column(length = 5)
    private String numeroIdentification;

    @Column(nullable = false)
    private LocalDate dateCreation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gerant_id")
    private Gerant gerant;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Conseiller> conseillers = new ArrayList<>();
}
