package org.example.proxibanque_achraf_chawki.domain.port.in;

import org.example.proxibanque_achraf_chawki.application.dto.AuditDTO;

public interface AuditUseCase {
    AuditDTO auditerAgence(String numeroAgence);
}
