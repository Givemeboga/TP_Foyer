package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Chambre;

import java.util.List;

public interface ChambreService {
    Chambre createChambre(Chambre c);
    Chambre updateChambre(Long id, Chambre c);
    void deleteChambre(Long id);
    Chambre getChambreById(Long id);
    List<Chambre> getAllChambres();
}