package com.sistemasuci.controller;

import com.sistemasuci.entity.Persona;
import com.sistemasuci.service.PersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/all")
    public List<Persona> listar() {
        return personaService.listar();
    }

    @GetMapping("/find/{id}")
    public Optional<Persona> find(@PathVariable Integer id) {
        return personaService.listarId(id);
    }

    @PostMapping("/guardar")
    public Persona insertar(@RequestBody Persona per) {
        return personaService.insertar(per);
    }

    @PutMapping("/actualizar")
    public Persona actualizar(@RequestBody Persona per) {
        return personaService.actualizar(per);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody Persona per) {
        personaService.eliminar(per);
    }
}
