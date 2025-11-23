package org.esprim.tpfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Renamed from idChambre to id

    private String numeroChambre; // Changed from Long to String

    @Enumerated(EnumType.STRING)
    private type_chambre typeC;

    private int capacite; // Added field for room capacity

    @ManyToOne(cascade = CascadeType.ALL)
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private List<Reservation> reservations; // Added mappedBy for bidirectional relationship
}