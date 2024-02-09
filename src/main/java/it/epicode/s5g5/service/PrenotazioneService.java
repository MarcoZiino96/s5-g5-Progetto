package it.epicode.s5g5.service;


import it.epicode.s5g5.bean.Postazione;
import it.epicode.s5g5.bean.Prenotazione;
import it.epicode.s5g5.bean.Utente;
import it.epicode.s5g5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    public void savePrenotazione(Prenotazione prenotazione) throws Exception{
        validitaCampi(prenotazione);
        LocalDate dataPrenotazione = prenotazione.getDataPrenotazione();
        Postazione postazione = prenotazione.getPostazione();
        Utente utente = prenotazione.getUtente();
        boolean postazioneOccupata = prenotazioneRepository.verificaPrenotazione(postazione, dataPrenotazione);
        boolean disponibilitaUtente = prenotazioneRepository.verificaDisponibilitaUtente(utente, dataPrenotazione);

        if(postazioneOccupata){
            throw new IllegalStateException("La postazione è occupata, scegli un'altro giorno.");
        }

        if (disponibilitaUtente){
            throw new IllegalStateException("hai gia una prenotazione attiva in questa data");
        }
        prenotazioneRepository.save(prenotazione);
    }

    public  Prenotazione cercaPrenotazione(int id){
        return prenotazioneRepository.findById(id).get();
    }

    public void deletePrenotazione(int id){
        prenotazioneRepository.deleteById(id);
    }

    public void validitaCampi(Prenotazione p) throws Exception{

        if(p.getDataPrenotazione() == null){

            throw new Exception("Non hai inserito una data,imposta una data per effettuare una prenotazione.");

        }

        if(p.getPostazione() == null){

            throw new Exception("Non hai inserito una postazione, associa una postazione per effettuare una prenotazione.");

        }

        if(p.getUtente() == null){

            throw new Exception("Non hai inserito nessun utente, associa un utente alla prenotazione.");

        }

    }

}


