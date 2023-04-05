package com.sistemasuci.controller;

import com.sistemasuci.entity.Personal;
import com.sistemasuci.service.PersonalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;
    
    @GetMapping
    public List<Personal> listar() {
        return personalService.listar();
    }
    
    @PostMapping
    public Personal insertar(@RequestBody Personal per) {
        return personalService.insertar(per);
    }
    
    @PutMapping
    public Personal actualizar(@RequestBody Personal per) {
        return personalService.actualizar(per);
    }
    
    @DeleteMapping
    public void eliminar(@RequestBody Personal per) {
        personalService.eliminar(per);
    }
}
