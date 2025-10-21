package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Etudiant;
import org.esprim.tpfoyer.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant createEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Long id, Etudiant e) {
        Etudiant existingEtudiant = etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant not found"));
        existingEtudiant.setNomEt(e.getNomEt());
        existingEtudiant.setPrenomEt(e.getPrenomEt());
        existingEtudiant.setCin(e.getCin());
        existingEtudiant.setEcole(e.getEcole());
        existingEtudiant.setDateNaissance(e.getDateNaissance());
        existingEtudiant.setReservations(e.getReservations());
        return etudiantRepository.save(existingEtudiant);
    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant not found"));
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
}