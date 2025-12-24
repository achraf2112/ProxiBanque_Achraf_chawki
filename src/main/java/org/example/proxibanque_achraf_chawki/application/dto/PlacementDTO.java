package org.example.proxibanque_achraf_chawki.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlacementDTO {
    private Long clientId;
    private String bourse; // PARIS, NEW_YORK, TOKYO
    private Double montant;
    private String typeActif;
}
