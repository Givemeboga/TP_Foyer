package org.esprim.tpfoyer.services;

import org.esprim.tpfoyer.entities.Bloc;
import org.esprim.tpfoyer.entities.Chambre;
import org.esprim.tpfoyer.entities.Etudiant;
import org.esprim.tpfoyer.entities.Reservation;
import org.esprim.tpfoyer.repositories.BlocRepository;
import org.esprim.tpfoyer.repositories.ChambreRepository;
import org.esprim.tpfoyer.repositories.EtudiantRepository;
import org.esprim.tpfoyer.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Reservation createReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation r) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));
        existingReservation.setAnneeUniversitaire(r.getAnneeUniversitaire());
        existingReservation.setEstValide(r.isEstValide());
        existingReservation.setEtudiant(r.getEtudiant());
        return reservationRepository.save(existingReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Réservation introuvable"));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable avec l'ID : " + idBloc));

        Etudiant etudiant = etudiantRepository.findById(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable avec le CIN : " + cinEtudiant));

        Chambre chambre = chambreRepository.findFirstByBlocAndReservationsCountLessThanCapacity(bloc);
        if (chambre == null) {
            throw new RuntimeException("Aucune chambre disponible dans le bloc : " + bloc.getNomBloc());
        }

        String anneeUniversitaire = String.valueOf(java.time.Year.now().getValue());
        String numReservation = chambre.getNumeroChambre() + "-" + bloc.getNomBloc() + "-" + anneeUniversitaire;

        Reservation reservation = new Reservation();
        reservation.setNumReservation(numReservation);
        reservation.setChambre(chambre);
        reservation.setEtudiant(etudiant);
        reservation.setEstValide(true);

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Reservation reservation = reservationRepository.findByEtudiant_Cin(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable pour l'étudiant avec le CIN : " + cinEtudiant));

        reservation.setEstValide(false);

        reservation.setEtudiant(null);

        Chambre chambre = reservation.getChambre();
        if (chambre != null) {
            chambre.getReservations().remove(reservation);
            reservation.setChambre(null);
        }

        return reservationRepository.save(reservation);
    }
}