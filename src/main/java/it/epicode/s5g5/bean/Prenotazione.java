package it.epicode.s5g5.bean;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequenza_postazioni", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name="postazione_fk")
    private Postazione postazione;

    private LocalDate dataInizioPrenotazione;

    private LocalDate dataFinePrenotazione;

    @ManyToOne
    @JoinColumn(name = "utente_fk")
    private Utente utente;


    public Prenotazione(Postazione p) throws Exception{

        if (!p.getStato()){
           throw new RuntimeException("Postazione occupata");
        }else{
            p.setStato(false);
            this.dataInizioPrenotazione = LocalDate.now();
            this.dataFinePrenotazione = dataInizioPrenotazione.plusDays(1);
            this.postazione = p;
        }
    }

}
