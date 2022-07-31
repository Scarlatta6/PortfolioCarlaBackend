
package com.portfolio.cya.service;

import com.portfolio.cya.interfaceService.IPersonaService;
import com.portfolio.cya.model.Persona;
import com.portfolio.cya.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService implements IPersonaService{
    
    @Autowired IPersonaRepository iPersoRepo;

    @Override
    public List<Persona> getPersona() {
                return iPersoRepo.findAll();
    }

    @Override
    public void savePersona(Persona pers) {
        iPersoRepo.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        iPersoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return iPersoRepo.findById(id).orElse(null);
    }
    
}
