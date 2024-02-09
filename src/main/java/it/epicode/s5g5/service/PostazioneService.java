package it.epicode.s5g5.service;


import it.epicode.s5g5.bean.Postazione;
import it.epicode.s5g5.bean.TipoPostazione;
import it.epicode.s5g5.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    PostazioneRepository postazioneRepository;

    public void savePostazione(Postazione p){
        postazioneRepository.save(p);
    }

    public Postazione cercaPostazione(int id){
        return postazioneRepository.findById(id).get();
    }

    public void deletePostazione(int id){
        postazioneRepository.deleteById(id);
    }

    public List<Postazione> cercaPostazionePerCitta(TipoPostazione tipoPostazione, String citta){
        return postazioneRepository.cercaPerTipoECitta(tipoPostazione, citta);
    }
}
