package it.epicode.s5g5.bean;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequenza_postazioni", initialValue = 1, allocationSize = 1)
    private int id;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private int numeroMassimoPartecipanti;

    @ManyToOne
    @JoinColumn(name="edificio_fk")
    private Edificio edificio;


    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    private Boolean stato = true;


}
