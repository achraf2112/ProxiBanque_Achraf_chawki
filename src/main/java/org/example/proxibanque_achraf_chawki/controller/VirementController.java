package org.example.proxibanque_achraf_chawki.controller;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.dto.VirementDTO;
import org.example.proxibanque_achraf_chawki.service.VirementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/virements")
@RequiredArgsConstructor
public class VirementController {

    private final VirementService virementService;

    @PostMapping
    public ResponseEntity<String> virement(@RequestBody VirementDTO dto) {
        virementService.effectuerVirement(dto);
        return ResponseEntity.ok("Virement effectué");
    }
}

