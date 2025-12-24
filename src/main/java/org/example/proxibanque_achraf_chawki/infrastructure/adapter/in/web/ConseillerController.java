package org.example.proxibanque_achraf_chawki.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.domain.model.Conseiller;
import org.example.proxibanque_achraf_chawki.domain.port.in.ConseillerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conseillers")
@RequiredArgsConstructor
public class ConseillerController {

    private final ConseillerUseCase conseillerUseCase;

    @PostMapping
    public ResponseEntity<Conseiller> create(@RequestBody Conseiller conseiller) {
        return ResponseEntity.ok(conseillerUseCase.createConseiller(conseiller));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conseiller> get(@PathVariable Long id) {
        return ResponseEntity.ok(conseillerUseCase.getConseiller(id));
    }

    @PostMapping("/{conseillerId}/assign/{clientId}")
    public ResponseEntity<String> assignClient(@PathVariable Long conseillerId, @PathVariable Long clientId) {
        conseillerUseCase.assignClient(conseillerId, clientId);
        return ResponseEntity.ok("Client assigné avec succès");
    }
}