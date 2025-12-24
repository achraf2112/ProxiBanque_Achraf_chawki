package org.example.proxibanque_achraf_chawki.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.domain.model.CompteBancaire;
import org.example.proxibanque_achraf_chawki.domain.model.CompteCourant;
import org.example.proxibanque_achraf_chawki.domain.model.CompteEpargne;
import org.example.proxibanque_achraf_chawki.domain.port.in.CompteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comptes")
@RequiredArgsConstructor
public class CompteController {

    private final CompteUseCase compteUseCase;

    @PostMapping("/courant/{clientId}")
    public ResponseEntity<CompteCourant> createCourant(@PathVariable Long clientId) {
        return ResponseEntity.ok(compteUseCase.createCompteCourant(clientId));
    }

    @PostMapping("/epargne/{clientId}")
    public ResponseEntity<CompteEpargne> createEpargne(@PathVariable Long clientId) {
        return ResponseEntity.ok(compteUseCase.createCompteEpargne(clientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompteBancaire> get(@PathVariable Long id) {
        return ResponseEntity.ok(compteUseCase.getCompte(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        compteUseCase.deleteCompte(id);
        return ResponseEntity.ok("Compte supprimé avec succès");
    }
}
