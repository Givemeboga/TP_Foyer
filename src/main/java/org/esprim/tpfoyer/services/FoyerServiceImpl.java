package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Foyer;
import org.esprim.tpfoyer.entities.Universite;
import org.esprim.tpfoyer.repositories.FoyerRepository;
import org.esprim.tpfoyer.repositories.UniversiteRepository;
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
    @Autowired
    private UniversiteRepository UniversiteRepository;

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = UniversiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université introuvable avec l'ID : " + idUniversite));

        if (foyer.getBlocs() != null) {
            foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));

        }

        foyer.setUniversite(universite);
        return foyerRepository.save(foyer);
    }
}