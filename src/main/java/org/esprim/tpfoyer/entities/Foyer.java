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

public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private String capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    private Universite universite;
    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bloc> blocs;
}
