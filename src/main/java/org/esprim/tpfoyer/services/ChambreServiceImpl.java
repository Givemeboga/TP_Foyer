package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Chambre;
import org.esprim.tpfoyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Chambre createChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Long id, Chambre c) {
        Chambre existingChambre = chambreRepository.findById(id).orElseThrow(() -> new RuntimeException("Chambre not found"));
        existingChambre.setNumeroChambre(c.getNumeroChambre());
        existingChambre.setTypeC(c.getTypeC());
        existingChambre.setBloc(c.getBloc());
        return chambreRepository.save(existingChambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id).orElseThrow(() -> new RuntimeException("Chambre not found"));
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }
}