package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant createEtudiant(Etudiant e);
    Etudiant updateEtudiant(Long id, Etudiant e);
    void deleteEtudiant(Long id);
    Etudiant getEtudiantById(Long id);
    List<Etudiant> getAllEtudiants();
}