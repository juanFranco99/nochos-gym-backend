package com.system.nocho.gym.service;

import com.system.nocho.gym.exception.RecursoNoEncontradoException;
import com.system.nocho.gym.model.Entidad;
import com.system.nocho.gym.model.Modalidad;
import com.system.nocho.gym.repository.EntidadRepository;
import com.system.nocho.gym.repository.ModalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadService {

    @Autowired
    private ModalidadRepository repository;

    public List<Modalidad> finAll(){
        return repository.findAll();
    }

    public Modalidad getById(Long id){
        Optional<Modalidad> opt = repository.findById(id);
        if(!opt.isPresent())  {
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        return opt.get();
    }

    public Modalidad add(Modalidad obj){
        repository.save(obj);
        return obj;
    }

    public Modalidad update(Long id, Modalidad obj){
        Optional<Modalidad> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        Modalidad objUpdate = opt.get();
        repository.save(objUpdate);
        return  objUpdate;
    }

    public void delete(Long id){
        Optional<Modalidad> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        repository.deleteById(id);
    }

}
