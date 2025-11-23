package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Bloc;
import org.esprim.tpfoyer.entities.Chambre;
import org.esprim.tpfoyer.repositories.BlocRepository;
import org.esprim.tpfoyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BlocServiceImpl implements BlocService {

    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    private ChambreRepository chambreRepository;

    // Constructor-based injection
    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    @Override
    public Bloc createBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Long id, Bloc b) {
        Bloc existingBloc = blocRepository.findById(id).orElseThrow(() -> new RuntimeException("Bloc not found"));
        existingBloc.setNomBloc(b.getNomBloc());
        existingBloc.setCapaciteBloc(b.getCapaciteBloc());
        return blocRepository.save(existingBloc);
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElseThrow(() -> new RuntimeException("Bloc not found"));
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc affecterChambreABloc(List<Long> numChambre, Long idBloc) {
        Chambre chambre = chambreRepository.findAllByNumChambreIn(numChambre)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Chambre introuvable avec le numéro : " + numChambre.get(0)));
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable avec l'ID : " + idBloc));
        if (chambre.getBloc() != null) {
            throw new RuntimeException("La chambre est déjà affectée à un bloc.");
        }
        bloc.getChambres().add(chambre);
        chambre.setBloc(bloc);
        blocRepository.save(bloc);
        chambreRepository.save(chambre);
        return bloc;
    }
}