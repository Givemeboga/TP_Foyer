package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Chambre;
import org.esprim.tpfoyer.entities.type_chambre;
import org.esprim.tpfoyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class ChambreServiceImpl implements ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Chambre createChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Long id, Chambre c) {
        Chambre existingChambre = chambreRepository.findById(id).orElseThrow(() -> new RuntimeException("Chambre not found"));
        existingChambre.setNumeroChambre(c.getNumeroChambre());
        existingChambre.setTypeC(c.getTypeC());
        existingChambre.setBloc(c.getBloc());
        return chambreRepository.save(existingChambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id).orElseThrow(() -> new RuntimeException("Chambre not found"));
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, type_chambre typeC) {

        return chambreRepository.findChambresByBlocAndTypeJPQL(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, type_chambre type) {
        String anneeUniversitaire = String.valueOf(Year.now().getValue());
        return chambreRepository.findNonReservedRoomsByUniversityAndType(nomUniversite, type, anneeUniversitaire);
    }


}