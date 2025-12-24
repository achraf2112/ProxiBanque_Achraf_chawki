package org.example.proxibanque_achraf_chawki.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirementDTO {
    private Long compteSourceId;
    private Long compteDestId;
    private Double montant;
}
