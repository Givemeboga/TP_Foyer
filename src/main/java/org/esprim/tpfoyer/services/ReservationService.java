package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation r);

    Reservation updateReservation(String id, Reservation r);

    void deleteReservation(String id);

    Reservation getReservationById(String id);

    List<Reservation> getAllReservations();

    Reservation ajouterReservation(long idBloc, long cinEtudiant);

    Reservation annulerReservation(long cinEtudiant);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(String anneeUniversite, String nomUniversite);
}