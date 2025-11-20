package org.example.proxibanque_achraf_chawki.controller;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.entities.Conseiller;
import org.example.proxibanque_achraf_chawki.service.ConseillerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conseillers")
@RequiredArgsConstructor
public class ConseillerController {

    private final ConseillerService conseillerService;

    @PostMapping
    public ResponseEntity<Conseiller> create(@RequestBody Conseiller conseiller) {
        return ResponseEntity.ok(conseillerService.createConseiller(conseiller));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conseiller> get(@PathVariable Long id) {
        return ResponseEntity.ok(conseillerService.getConseiller(id));
    }

    @PostMapping("/{conseillerId}/assign/{clientId}")
    public ResponseEntity<String> assignClient(@PathVariable Long conseillerId, @PathVariable Long clientId) {
        conseillerService.assignClient(conseillerId, clientId);
        return ResponseEntity.ok("Client assigné avec succès");
    }
}

