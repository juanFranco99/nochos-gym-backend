package com.system.nocho.gym.service;

import com.system.nocho.gym.exception.RecursoNoEncontradoException;
import com.system.nocho.gym.model.Entidad;
import com.system.nocho.gym.repository.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadService {
    @Autowired
    private EntidadRepository repository;

    public List<Entidad> finAll(){
        return repository.findAll();
    }

    public Entidad getById(Long id){
        Optional<Entidad> opt = repository.findById(id);
        if(!opt.isPresent())  {
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        return opt.get();
    }

    public Entidad add(Entidad obj){
        repository.save(obj);
        return obj;
    }

    public Entidad update(Long id, Entidad obj){
        Optional<Entidad> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        Entidad objUpdate = opt.get();
        repository.save(objUpdate);
        return  objUpdate;
    }

    public void delete(Long id){
        Optional<Entidad> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        repository.deleteById(id);
    }
}
