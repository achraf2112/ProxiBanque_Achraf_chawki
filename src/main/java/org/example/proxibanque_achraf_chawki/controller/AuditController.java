package org.example.proxibanque_achraf_chawki.controller;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.dto.AuditDTO;
import org.example.proxibanque_achraf_chawki.service.AuditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/audit")
@RequiredArgsConstructor
public class AuditController {

    private final AuditService auditService;

    @GetMapping("/agence/{numeroAgence}")
    public ResponseEntity<AuditDTO> auditer(@PathVariable String numeroAgence) {
        return ResponseEntity.ok(auditService.auditerAgence(numeroAgence));
    }
}
