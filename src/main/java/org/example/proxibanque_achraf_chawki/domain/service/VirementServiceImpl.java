package org.example.proxibanque_achraf_chawki.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.application.dto.VirementDTO;
import org.example.proxibanque_achraf_chawki.domain.model.CompteBancaire;
import org.example.proxibanque_achraf_chawki.domain.port.in.VirementUseCase;
import org.example.proxibanque_achraf_chawki.domain.port.out.CompteBancaireRepositoryPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VirementServiceImpl implements VirementUseCase {

    private final CompteBancaireRepositoryPort compteBancaireRepositoryPort;

    @Override
    @Transactional
    public void effectuerVirement(VirementDTO dto) {
        CompteBancaire src = compteBancaireRepositoryPort.findById(dto.getCompteSourceId())
                .orElseThrow(() -> new RuntimeException("Compte source introuvable"));
        CompteBancaire dest = compteBancaireRepositoryPort.findById(dto.getCompteDestId())
                .orElseThrow(() -> new RuntimeException("Compte destination introuvable"));

        if (src.getSolde() < dto.getMontant()) {
            throw new RuntimeException("Solde insuffisant");
        }

        src.setSolde(src.getSolde() - dto.getMontant());
        dest.setSolde(dest.getSolde() + dto.getMontant());

        compteBancaireRepositoryPort.save(src);
        compteBancaireRepositoryPort.save(dest);
    }
}
