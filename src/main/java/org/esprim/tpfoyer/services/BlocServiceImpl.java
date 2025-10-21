package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Bloc;
import org.esprim.tpfoyer.repositories.BlocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements BlocService {

    private final BlocRepository blocRepository;

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
}