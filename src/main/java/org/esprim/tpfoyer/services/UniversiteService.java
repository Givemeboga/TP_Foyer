package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Universite;

import java.util.List;

public interface UniversiteService {
    Universite createUniversite(Universite u);
    Universite updateUniversite(Long id, Universite u);
    void deleteUniversite(Long id);
    Universite getUniversiteById(Long id);
    List<Universite> getAllUniversites();
    Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite);
    Universite  desaffecterFoyerDeUniversite(Long idUniversite);
}