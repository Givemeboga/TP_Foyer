package org.esprim.tpfoyer.controllers;

import org.esprim.tpfoyer.entities.Etudiant;
import org.esprim.tpfoyer.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant e) {
        return etudiantService.createEtudiant(e);
    }

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant e) {
        return etudiantService.updateEtudiant(id, e);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }
}