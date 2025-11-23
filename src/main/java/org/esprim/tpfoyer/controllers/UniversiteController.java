package org.esprim.tpfoyer.controllers;

import org.esprim.tpfoyer.entities.Universite;
import org.esprim.tpfoyer.services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    @Autowired
    private UniversiteService universiteService;

    @PostMapping
    public Universite createUniversite(@RequestBody Universite u) {
        return universiteService.createUniversite(u);
    }

    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite u) {
        return universiteService.updateUniversite(id, u);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteById(id);
    }

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    @PostMapping("/{idFoyer}/affect-to-universite")
    public Universite affecterFoyerAUniversite(@PathVariable Long idFoyer, @RequestParam String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @DeleteMapping("/{idUniversite}/desaffect-foyer")
    public Universite desaffecterFoyerDeUniversite(@PathVariable Long idUniversite) {
        return universiteService.desaffecterFoyerDeUniversite(idUniversite);
    }
}