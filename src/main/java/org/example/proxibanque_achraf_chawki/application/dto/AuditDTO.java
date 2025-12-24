package org.example.proxibanque_achraf_chawki.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDTO {
    private String numeroAgence;
    private LocalDate dateAudit;
    private List<String> anomalies;
    private int nbClientsAudites;
}
