package org.esprim.tpfoyer.repositories;

import org.esprim.tpfoyer.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
}
