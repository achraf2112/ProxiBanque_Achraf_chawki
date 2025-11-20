package org.example.proxibanque_achraf_chawki.controller;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.entities.CarteBancaire;
import org.example.proxibanque_achraf_chawki.enums.TypeCarte;
import org.example.proxibanque_achraf_chawki.service.CarteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartes")
@RequiredArgsConstructor
public class CarteController {

    private final CarteService carteService;

    @PostMapping("/create/{clientId}")
    public ResponseEntity<CarteBancaire> createCarte(@PathVariable Long clientId,
                                                     @RequestParam TypeCarte type) {
        return ResponseEntity.ok(carteService.createCarte(clientId, type));
    }

    @PutMapping("/desactiver/{carteId}")
    public ResponseEntity<String> desactiverCarte(@PathVariable Long carteId) {
        carteService.desactiverCarte(carteId);
        return ResponseEntity.ok("Carte désactivée avec succès");
    }
}

