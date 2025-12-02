package org.esprim.tpfoyer.repositories;

import org.esprim.tpfoyer.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    @Query("SELECT r FROM Reservation r WHERE r.etudiant.cin = :cinEtudiant")
    Optional<Reservation> findByEtudiant_Cin(@Param("cinEtudiant") Long cinEtudiant);

    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire = :anneeUniversite AND r.chambre.bloc.foyer.universite.nomUniversite = :nomUniversite")
    List<Reservation> findReservationsByAnneeUniversitaireAndNomUniversite(
            @Param("anneeUniversite") String anneeUniversite,
            @Param("nomUniversite") String nomUniversite);
}