package it.epicode.s5g5.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig{

    @Bean("sant'anna")
    public Edificio edificio(){
        Edificio e = new Edificio();
        e.setCitta("Messina");
        e.setNome("palazzo Sant'anna");
        e.setIndirizzo("gabriele d'annunzio 3");
        return  e;
    }

    @Bean("marco")
    public Utente utente(){
        Utente u = new Utente();
        u.setNome("marco");
        u.setCognome("ziino");
        u.setEmail("maro88@gmail.com");
        u.setUserName("Uomo Cane");
        return u;
    }

    @Bean("salaMultimediale sant'anna")
    public Postazione postazione(){
        Postazione p = new Postazione();
        p.setNumeroMassimoPartecipanti(50);
        p.setTipoPostazione(TipoPostazione.SALA);
        p.setDescrizione("sala ampia insonorizzata");
        return p;
    }

//    @Bean("prenotazione1")
//    public Prenotazione prenotaione(){
//        return new Prenotazione();
//    }
}
