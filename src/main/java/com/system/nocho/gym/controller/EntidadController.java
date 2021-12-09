package com.system.nocho.gym.controller;

import com.system.nocho.gym.model.Entidad;
import com.system.nocho.gym.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/entidad")
public class EntidadController extends GenericController{

    @Autowired
    private EntidadService service;

    @GetMapping
    public ResponseEntity<List<Entidad>> list(){
        return ResponseEntity.ok().body(service.finAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            Entidad entidad = service.getById(id);
            return success(entidad);
        }catch (Exception e) {
            return badRequest(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Entidad obj ) {
        try{
            Entidad objAdd = service.add(obj);
            return success(objAdd);
        } catch (Exception e) {
            return badRequest(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid Entidad obj) {
        try {
            Entidad entidad = service.update(id, obj);
            return success(entidad);
        }catch (Exception e) {
            return badRequest(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return deleteRequest();
        }catch (Exception e) {
            return badRequest(e);
        }
    }

}
