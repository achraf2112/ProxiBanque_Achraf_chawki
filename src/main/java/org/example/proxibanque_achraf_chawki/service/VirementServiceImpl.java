package org.example.proxibanque_achraf_chawki.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.proxibanque_achraf_chawki.dao.CompteBancaireRepository;
import org.example.proxibanque_achraf_chawki.dao.VirementRepository;
import org.example.proxibanque_achraf_chawki.dto.VirementDTO;
import org.example.proxibanque_achraf_chawki.entities.CompteBancaire;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VirementServiceImpl implements VirementService {

    private final CompteBancaireRepository compteRepository;
    private final VirementRepository virementRepository;

    @Override
    @Transactional
    public void effectuerVirement(VirementDTO dto) {
        CompteBancaire src = compteRepository.findById(dto.getCompteSourceId())
                .orElseThrow(() -> new RuntimeException("Compte source introuvable"));
        CompteBancaire dest = compteRepository.findById(dto.getCompteDestId())
                .orElseThrow(() -> new RuntimeException("Compte destination introuvable"));

        if (src.getSolde() < dto.getMontant())
            throw new RuntimeException("Solde insuffisant");

        src.setSolde(src.getSolde() - dto.getMontant());
        dest.setSolde(dest.getSolde() + dto.getMontant());
        compteRepository.save(src);
        compteRepository.save(dest);
    }
}

