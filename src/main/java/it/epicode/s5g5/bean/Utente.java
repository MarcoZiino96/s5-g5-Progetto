package it.epicode.s5g5.bean;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequenza_edifici", initialValue = 1, allocationSize = 1)
    private int id;

    private String UserName;

    private String nome;

    private String cognome;

    private String email;

    @OneToMany(mappedBy = "utente")
   private List<Prenotazione> prenotazione;

}
