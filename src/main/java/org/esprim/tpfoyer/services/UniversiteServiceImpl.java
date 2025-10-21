package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Universite;
import org.esprim.tpfoyer.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImpl implements UniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Universite createUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Long id, Universite u) {
        Universite existingUniversite = universiteRepository.findById(id).orElseThrow(() -> new RuntimeException("Universite not found"));
        existingUniversite.setNomUniversite(u.getNomUniversite());
        existingUniversite.setAdresse(u.getAdresse());
        existingUniversite.setFoyer(u.getFoyer());
        return universiteRepository.save(existingUniversite);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElseThrow(() -> new RuntimeException("Universite not found"));
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }
}