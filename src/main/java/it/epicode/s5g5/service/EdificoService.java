package it.epicode.s5g5.service;


import it.epicode.s5g5.bean.Edificio;
import it.epicode.s5g5.repository.EdificoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificoService {

    @Autowired
    EdificoRepository edificioRepository;

    public void saveEdificio(Edificio e){
        edificioRepository.save(e);
    }

    public Edificio cercaEdificio(int id){
        return  edificioRepository.findById(id).get();
    }

    public void deleteEdificio(int id){
        edificioRepository.deleteById(id);
    }
}
