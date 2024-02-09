package it.epicode.s5g5.service;


import it.epicode.s5g5.bean.Prenotazione;
import it.epicode.s5g5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    public void savePrenotazione(Prenotazione p){
        prenotazioneRepository.save(p);
    }

    public  Prenotazione cercaPrenotazione(int id){
        return prenotazioneRepository.findById(id).get();
    }

    public void deletePrenotazione(int id){
        prenotazioneRepository.deleteById(id);
    }
}
