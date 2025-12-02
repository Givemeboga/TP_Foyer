package org.esprim.tpfoyer.repositories;

import org.esprim.tpfoyer.entities.Bloc;
import org.esprim.tpfoyer.entities.Chambre;
import org.esprim.tpfoyer.entities.type_chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {

    @Query("SELECT c FROM Chambre c WHERE c.numeroChambre IN :numChambre")
    List<Chambre> findAllByNumChambreIn(@Param("numChambre") List<Long> numChambre);

    @Query("SELECT c FROM Chambre c WHERE c.bloc = :bloc AND " +
            "(SELECT COUNT(r) FROM Reservation r WHERE r.chambre = c) < " +
            "CASE c.typeC " +
            "WHEN org.esprim.tpfoyer.entities.type_chambre.SIMPLE THEN 1 " +
            "WHEN org.esprim.tpfoyer.entities.type_chambre.DOUBLE THEN 2 " +
            "WHEN org.esprim.tpfoyer.entities.type_chambre.TRIPLE THEN 3 END " +
            "ORDER BY c.id ASC")
    Chambre findFirstByBlocAndReservationsCountLessThanCapacity(@Param("bloc") Bloc bloc);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findChambresByBlocAndTypeJPQL(@Param("idBloc") long idBloc, @Param("typeC") type_chambre typeC);

    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, type_chambre typeC);

    @Query("SELECT c FROM Chambre c WHERE c.typeC = :type AND c.bloc.foyer.universite.nomUniversite = :nomUniversite " +
            "AND c.id NOT IN (SELECT r.chambre.id FROM Reservation r WHERE r.anneeUniversitaire = :anneeUniversitaire)")
    List<Chambre> findNonReservedRoomsByUniversityAndType(
            @Param("nomUniversite") String nomUniversite,
            @Param("type") type_chambre type,
            @Param("anneeUniversitaire") String anneeUniversitaire);
}