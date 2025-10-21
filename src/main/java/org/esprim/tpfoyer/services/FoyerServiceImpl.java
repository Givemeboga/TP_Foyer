package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Foyer;
import org.esprim.tpfoyer.repositories.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements FoyerService {

    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public Foyer createFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Long id, Foyer f) {
        Foyer existingFoyer = foyerRepository.findById(id).orElseThrow(() -> new RuntimeException("Foyer not found"));
        existingFoyer.setNomFoyer(f.getNomFoyer());
        existingFoyer.setCapaciteFoyer(f.getCapaciteFoyer());
        existingFoyer.setBlocs(f.getBlocs());
        return foyerRepository.save(existingFoyer);
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id).orElseThrow(() -> new RuntimeException("Foyer not found"));
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }
}