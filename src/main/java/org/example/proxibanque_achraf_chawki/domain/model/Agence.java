package org.example.proxibanque_achraf_chawki.domain.model;

import lombok.Data;
import org.example.proxibanque_achraf_chawki.entities.Conseiller;
import org.example.proxibanque_achraf_chawki.entities.Gerant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Agence {


    private String numeroIdentification;

    private LocalDate dateCreation;

    private Gerant gerant;

    private List<Conseiller> conseillers = new ArrayList<>();
}
