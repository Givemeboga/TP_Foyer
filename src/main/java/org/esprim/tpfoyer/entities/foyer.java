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

public class foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private String capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    private universite universite;
    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<bloc> blocs;
}
