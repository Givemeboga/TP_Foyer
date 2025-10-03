package org.esprim.tpfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;
}
