package org.example.proxibanque_achraf_chawki.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.domain.model.CarteBancaire;
import org.example.proxibanque_achraf_chawki.domain.model.enums.TypeCarte;
import org.example.proxibanque_achraf_chawki.domain.port.in.CarteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartes")
@RequiredArgsConstructor
public class CarteController {

    private final CarteUseCase carteUseCase;

    @PostMapping("/create/{clientId}")
    public ResponseEntity<CarteBancaire> createCarte(@PathVariable Long clientId,
                                                     @RequestParam TypeCarte type) {
        return ResponseEntity.ok(carteUseCase.createCarte(clientId, type));
    }

    @PutMapping("/desactiver/{carteId}")
    public ResponseEntity<String> desactiverCarte(@PathVariable Long carteId) {
        carteUseCase.desactiverCarte(carteId);
        return ResponseEntity.ok("Carte désactivée avec succès");
    }
}