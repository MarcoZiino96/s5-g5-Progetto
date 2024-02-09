package it.epicode.s5g5.service;


import it.epicode.s5g5.bean.Utente;
import it.epicode.s5g5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService{

    @Autowired
    UtenteRepository utenteRepository;

    public void saveUtente(Utente u){
        utenteRepository.save(u);
    }
  public Utente Cercautente(int id){
        return utenteRepository.findById(id).get();
  }

  public void deleteUtente(int id){
        utenteRepository.deleteById(id);
  }
}
