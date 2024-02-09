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

    private LocalDate dataPrenotazione;


    @ManyToOne
    @JoinColumn(name = "utente_fk")

    private Utente utente;

    private int numeroPartecipanti;

    public void setNumeroPartecipanti(int numeroPartecipanti) throws Exception{
        if (postazione == null) throw new Exception("Nessuna postazione è associata a questa prenotazione");
        if( numeroPartecipanti > postazione.getNumeroMassimoPartecipanti()) throw new Exception("i partecipanti superano la capienza massima");
        this.numeroPartecipanti = numeroPartecipanti;
    }
    }


