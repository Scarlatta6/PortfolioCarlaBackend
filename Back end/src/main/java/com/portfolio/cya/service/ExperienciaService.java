package com.portfolio.cya.service;

import com.portfolio.cya.model.Experiencia;
import com.portfolio.cya.repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ExperienciaService {
    @Autowired
    IExperienciaRepository iExpRepo;
    
    public List<Experiencia> list() {
        return iExpRepo.findAll();
    }
    
    public Optional<Experiencia> getOne(int id) {
        return iExpRepo.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE) {
        return iExpRepo.findByNombreE(nombreE);
    }
    
    public void save(Experiencia exp) {
        iExpRepo.save(exp);
    }
    
    public void delete(int id) {
        iExpRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return iExpRepo.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE) {
        return iExpRepo.existsByNombreE(nombreE);
    }
    
}
