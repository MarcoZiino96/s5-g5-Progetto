package it.epicode.s5g5;

import it.epicode.s5g5.bean.*;
import it.epicode.s5g5.service.EdificoService;
import it.epicode.s5g5.service.PostazioneService;
import it.epicode.s5g5.service.PrenotazioneService;
import it.epicode.s5g5.service.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    EdificoService edificioService;

    @Autowired
    PrenotazioneService prenotazioneService;

    @Autowired
    UtenteService utenteService;

    @Autowired
    PostazioneService postazioneService;

    private Logger logger = LoggerFactory.getLogger("s5g5");

    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Utente u = ctx.getBean("marco", Utente.class);
        utenteService.saveUtente(u);

        Edificio e = ctx.getBean("sant'anna", Edificio.class);
        edificioService.saveEdificio(e);


        Postazione post = ctx.getBean("salaMultimediale sant'anna", Postazione.class);
        post.setEdificio(e);
        postazioneService.savePostazione(post);

        Prenotazione pren = ctx.getBean("prenotazione1", Prenotazione.class);
        pren.setUtente(u);
        pren.setPostazione(post);
        prenotazioneService.savePrenotazione(pren);

    }



}
