package org.esprim.tpfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {
    @Id
    private String idReservation;

    private String anneeUniversitaire; // Changed from Date to String
    private boolean estValide;
    private String numReservation;

    @ManyToOne
    private Etudiant etudiant; // Changed from Set<Etudiant> to a single Etudiant

    @ManyToOne
    private Chambre chambre;
}