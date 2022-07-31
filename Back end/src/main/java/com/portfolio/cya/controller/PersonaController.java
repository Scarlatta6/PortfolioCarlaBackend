
package com.portfolio.cya.controller;

import com.portfolio.cya.interfaceService.IPersonaService;
import com.portfolio.cya.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService iPersoServ;
    
    @GetMapping ("/personas/traer")
    public List<Persona> getPersona() {
        return iPersoServ.getPersona();
    }
    
    @PostAuthorize("hasRole('ADMIN')")
    @PostMapping ("/personas/crear")
    public String createPersona (@RequestBody Persona personaACrear) {
        iPersoServ.savePersona(personaACrear);
        return "Creado correctamente";
    }
    
    @PostAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona (@PathVariable long id) {
    iPersoServ.deletePersona(id);
    return "Se elimino correctamente";
    }
    

    
    //URL:PUERTO/personas/editar/id?nombre & apellido & img
    @PostAuthorize("hasRole('ADMIN')")
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevaImg) {
        
        
        Persona personaAEditar = iPersoServ.findPersona(id);
        personaAEditar.setNombre(nuevoNombre);
        personaAEditar.setApellido(nuevoApellido);
        personaAEditar.setImg(nuevaImg);
        
        iPersoServ.savePersona(personaAEditar);
        
        
        return personaAEditar;  //Dudas con este return
    }
    
    /*@GetMapping ("/personas/traer/perfil/{id}")
    public Persona findPersona(@PathVariable Long id) {
        
        
       return  iPersoServ.findPersona(id);
       
            
            
    }
*/
    
     @GetMapping ("/personas/traer/perfil")
    public Persona findPersona() {
        
        
       return  iPersoServ.findPersona((long)3);
       
            
            
    }

}
