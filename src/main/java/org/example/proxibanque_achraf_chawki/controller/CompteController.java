package org.example.proxibanque_achraf_chawki.controller;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.entities.CompteBancaire;
import org.example.proxibanque_achraf_chawki.entities.CompteCourant;
import org.example.proxibanque_achraf_chawki.entities.CompteEpargne;
import org.example.proxibanque_achraf_chawki.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comptes")
@RequiredArgsConstructor
public class CompteController {

    private final CompteService compteService;

    @PostMapping("/courant/{clientId}")
    public ResponseEntity<CompteCourant> createCourant(@PathVariable Long clientId) {
        return ResponseEntity.ok(compteService.createCompteCourant(clientId));
    }

    @PostMapping("/epargne/{clientId}")
    public ResponseEntity<CompteEpargne> createEpargne(@PathVariable Long clientId) {
        return ResponseEntity.ok(compteService.createCompteEpargne(clientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompteBancaire> get(@PathVariable Long id) {
        return ResponseEntity.ok(compteService.getCompte(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        compteService.deleteCompte(id);
        return ResponseEntity.ok("Compte supprimé avec succès");
    }
}

