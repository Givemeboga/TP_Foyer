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
public class bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne
    foyer foyer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    private Set<chambre> chambres;
}
