package org.example.proxibanque_achraf_chawki.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.application.dto.VirementDTO;
import org.example.proxibanque_achraf_chawki.domain.port.in.VirementUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/virements")
@RequiredArgsConstructor
public class VirementController {

    private final VirementUseCase virementUseCase;

    @PostMapping
    public ResponseEntity<String> virement(@RequestBody VirementDTO dto) {
        virementUseCase.effectuerVirement(dto);
        return ResponseEntity.ok("Virement effectué");
    }
}