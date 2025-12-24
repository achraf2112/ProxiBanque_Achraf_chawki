package org.example.proxibanque_achraf_chawki.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.application.dto.AuditDTO;
import org.example.proxibanque_achraf_chawki.domain.port.in.AuditUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/audit")
@RequiredArgsConstructor
public class AuditController {

    private final AuditUseCase auditUseCase;

    @GetMapping("/agence/{numeroAgence}")
    public ResponseEntity<AuditDTO> auditer(@PathVariable String numeroAgence) {
        return ResponseEntity.ok(auditUseCase.auditerAgence(numeroAgence));
    }
}
