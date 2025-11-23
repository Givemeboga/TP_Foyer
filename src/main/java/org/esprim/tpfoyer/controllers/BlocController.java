package org.esprim.tpfoyer.controllers;

import org.esprim.tpfoyer.entities.Bloc;
import org.esprim.tpfoyer.services.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocs")
public class BlocController {

    @Autowired
    private BlocService blocService;

    @PostMapping
    public Bloc createBloc(@RequestBody Bloc b) {
        return blocService.createBloc(b);
    }

    @PutMapping("/{id}")
    public Bloc updateBloc(@PathVariable Long id, @RequestBody Bloc b) {
        return blocService.updateBloc(id, b);
    }

    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.deleteBloc(id);
    }

    @GetMapping("/{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.getBlocById(id);
    }

    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    @PostMapping("/{idBloc}/affect-chambres")
    public Bloc affecterChambreABloc(@RequestBody List<Long> numChambre, @PathVariable Long idBloc) {
        return blocService.affecterChambreABloc(numChambre, idBloc);
    }
}