package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation r);
    Reservation updateReservation(Long id, Reservation r);
    void deleteReservation(Long id);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
    Reservation ajouterReservation(long idBloc, long cinEtudiant);
    public Reservation annulerReservation (long cinEtudiant) ;
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(String anneeUniversite, String nomUniversite);

}