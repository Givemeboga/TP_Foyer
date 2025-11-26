package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Chambre;
import org.esprim.tpfoyer.entities.type_chambre;

import java.util.List;

public interface ChambreService {
    Chambre createChambre(Chambre c);
    Chambre updateChambre(Long id, Chambre c);
    void deleteChambre(Long id);
    Chambre getChambreById(Long id);
    List<Chambre> getAllChambres();
    List<Chambre> getChambresParBlocEtType(long idBloc, type_chambre typeC);
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, type_chambre type);

}