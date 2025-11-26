package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Chambre;
import org.esprim.tpfoyer.entities.Foyer;
import org.esprim.tpfoyer.entities.Universite;
import org.esprim.tpfoyer.repositories.FoyerRepository;
import org.esprim.tpfoyer.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(() -> new RuntimeException("Foyer introuvable avec l'ID : " + idFoyer));
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite).orElseThrow(() -> new RuntimeException("Universite introuvable avec le nom : " + nomUniversite));
        if (foyer.getUniversite() != null) {
            throw new RuntimeException("Le foyer est déjà affecté à une université.");
        }
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        universiteRepository.save(universite);
        foyerRepository.save(foyer);
        return universite;
    }

    @Override
    public Universite desaffecterFoyerDeUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(() -> new RuntimeException("Universite introuvable avec l'ID : " + idUniversite));

        Foyer foyer = universite.getFoyer();
        if (foyer == null) {
            throw new RuntimeException("Aucun foyer n'est affecté à cette université.");
        }
        universite.setFoyer(null);
        foyer.setUniversite(null);
        universiteRepository.save(universite);
        foyerRepository.save(foyer);
        return universite;
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Université introuvable avec le nom : " + nomUniversite));

        List<Chambre> chambres = new ArrayList<>();
        if (universite.getFoyer() != null) {
            Foyer foyer = universite.getFoyer();
            chambres.addAll(foyer.getChambres());
        }

        return chambres;
    }
}