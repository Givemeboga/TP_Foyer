package org.esprim.tpfoyer.repositories;

import org.esprim.tpfoyer.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findAllByNumChambreIn(Collection<Long> numChambres);
}
