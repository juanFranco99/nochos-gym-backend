package com.system.nocho.gym.controller;

import com.system.nocho.gym.model.ClienteModalidad;
import com.system.nocho.gym.service.ClienteModalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/cliente-modalidad")
public class ClienteModalidadController extends GenericController{

    @Autowired
    private ClienteModalidadService service;

    @GetMapping
    public ResponseEntity<List<ClienteModalidad>> list(){
        return ResponseEntity.ok().body(service.finAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            ClienteModalidad obj = service.getById(id);
            return success(obj);
        }catch (Exception e) {
            return badRequest(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody ClienteModalidad obj ) {
        try{
            ClienteModalidad objAdd = service.add(obj);
            return success(objAdd);
        } catch (Exception e) {
            return badRequest(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ClienteModalidad obj) {
        try {
            ClienteModalidad objUpdated = service.update(id, obj);
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
