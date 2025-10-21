package org.esprim.tpfoyer.controllers;

import org.esprim.tpfoyer.entities.Foyer;
import org.esprim.tpfoyer.services.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foyers")
public class FoyerController {

    @Autowired
    private FoyerService foyerService;

    @PostMapping
    public Foyer createFoyer(@RequestBody Foyer f) {
        return foyerService.createFoyer(f);
    }

    @PutMapping("/{id}")
    public Foyer updateFoyer(@PathVariable Long id, @RequestBody Foyer f) {
        return foyerService.updateFoyer(id, f);
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyer(id);
    }

    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable Long id) {
        return foyerService.getFoyerById(id);
    }

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyers();
    }
}