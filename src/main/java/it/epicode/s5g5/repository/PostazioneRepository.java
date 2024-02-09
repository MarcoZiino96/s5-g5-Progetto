package it.epicode.s5g5.repository;

import it.epicode.s5g5.bean.Postazione;
import it.epicode.s5g5.bean.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

   @Query("select p from Postazione p where p.tipoPostazione = :tipoPostazione and p.edificio.citta = :citta")
   List<Postazione> cercaPerTipoECitta(TipoPostazione tipoPostazione, String citta);
}
