package org.example.proxibanque_achraf_chawki.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.application.dto.ClientDTO;
import org.example.proxibanque_achraf_chawki.domain.port.in.ClientUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientUseCase clientUseCase;

    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO dto) {
        return ResponseEntity.ok(clientUseCase.createClient(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(clientUseCase.getClient(id));
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll() {
        return ResponseEntity.ok(clientUseCase.getAllClients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto) {
        return ResponseEntity.ok(clientUseCase.updateClient(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientUseCase.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}