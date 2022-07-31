
package com.portfolio.cya.interfaceService;

import com.portfolio.cya.model.Persona;
import java.util.List;


public interface IPersonaService {
    // Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona (Persona pers);
    
    //Eliminar un objeto buscandolo por ID
    public void deletePersona (Long id);
    
    //  buscar una persona por ID
    public Persona findPersona(Long id);
    
    
}
