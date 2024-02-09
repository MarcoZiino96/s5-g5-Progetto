package it.epicode.s5g5.repository;

import it.epicode.s5g5.bean.Postazione;
import it.epicode.s5g5.bean.Prenotazione;
import it.epicode.s5g5.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    @Query("select count(p) > 0 from Prenotazione p where p.postazione= :postazione and p.dataPrenotazione= :prenotazione")
    boolean verificaPrenotazione(Postazione postazione, LocalDate prenotazione);

    @Query("select count(p) > 0 from Prenotazione p where p.utente = :utente and p.dataPrenotazione = :dataPrenotazione")
    boolean verificaDisponibilitaUtente(Utente utente, LocalDate dataPrenotazione);
}
