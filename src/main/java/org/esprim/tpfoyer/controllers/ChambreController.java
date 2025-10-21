package org.esprim.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.entities.Chambre;
import org.esprim.tpfoyer.services.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
@AllArgsConstructor
public class ChambreController {


    private ChambreService chambreService;

    @PostMapping
    public Chambre createChambre(@RequestBody Chambre c) {
        return chambreService.createChambre(c);
    }

    @PutMapping("/{id}")
    public Chambre updateChambre(@PathVariable Long id, @RequestBody Chambre c) {
        return chambreService.updateChambre(id, c);
    }

    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
    }

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.getChambreById(id);
    }

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }
}