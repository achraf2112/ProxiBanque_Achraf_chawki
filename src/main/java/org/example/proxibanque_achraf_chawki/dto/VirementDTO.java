package org.example.proxibanque_achraf_chawki.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirementDTO {
    private Long compteSourceId;
    private Long compteDestId;
    private Double montant;
}
