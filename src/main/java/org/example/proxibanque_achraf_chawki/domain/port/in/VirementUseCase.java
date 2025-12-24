package org.example.proxibanque_achraf_chawki.domain.port.in;

import org.example.proxibanque_achraf_chawki.application.dto.VirementDTO;

public interface VirementUseCase {
    void effectuerVirement(VirementDTO dto);
}
