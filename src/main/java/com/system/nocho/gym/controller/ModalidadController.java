package com.system.nocho.gym.controller;

import com.system.nocho.gym.model.Modalidad;
import com.system.nocho.gym.service.ModalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/modalidad")
public class ModalidadController extends GenericController{

    @Autowired
    private ModalidadService service;

    @GetMapping
    public ResponseEntity<List<Modalidad>> list(){
        return ResponseEntity.ok().body(service.finAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            Modalidad obj = service.getById(id);
            return success(obj);
        }catch (Exception e) {
            return badRequest(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Modalidad obj ) {
        try{
            Modalidad objAdd = service.add(obj);
            return success(objAdd);
        } catch (Exception e) {
            return badRequest(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid Modalidad obj) {
        try {
            Modalidad objUpdated = service.update(id, obj);
            return success(objUpdated);
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
