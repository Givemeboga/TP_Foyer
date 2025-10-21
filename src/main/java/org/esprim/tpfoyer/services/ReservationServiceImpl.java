package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Reservation;
import org.esprim.tpfoyer.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation r) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        existingReservation.setAnneeUniversitaire(r.getAnneeUniversitaire());
        existingReservation.setEstValide(r.isEstValide());
        existingReservation.setEtudiants(r.getEtudiants());
        return reservationRepository.save(existingReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}