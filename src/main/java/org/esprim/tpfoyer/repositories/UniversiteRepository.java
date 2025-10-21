package org.esprim.tpfoyer.repositories;

import org.esprim.tpfoyer.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
}
