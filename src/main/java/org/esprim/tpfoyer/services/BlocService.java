package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Bloc;

import java.util.List;

public interface BlocService {
    Bloc createBloc(Bloc b);
    Bloc updateBloc(Long id, Bloc b);
    void deleteBloc(Long id);
    Bloc getBlocById(Long id);
    List<Bloc> getAllBlocs();
}