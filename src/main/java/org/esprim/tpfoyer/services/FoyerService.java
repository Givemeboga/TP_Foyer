package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Foyer;

import java.util.List;

public interface FoyerService {
    Foyer createFoyer(Foyer f);
    Foyer updateFoyer(Long id, Foyer f);
    void deleteFoyer(Long id);
    Foyer getFoyerById(Long id);
    List<Foyer> getAllFoyers();
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}