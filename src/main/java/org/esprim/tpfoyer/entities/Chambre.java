package org.esprim.tpfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idChambre;
    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private type_chambre typeC;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bloc bloc;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}