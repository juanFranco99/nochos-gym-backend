package com.system.nocho.gym.service;

import com.system.nocho.gym.exception.RecursoNoEncontradoException;
import com.system.nocho.gym.model.ClienteModalidad;
import com.system.nocho.gym.repository.ClienteModalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteModalidadService {

    @Autowired
    private ClienteModalidadRepository repository;

    public List<ClienteModalidad> finAll(){
        return repository.findAll();
    }

    public ClienteModalidad getById(Long id){
        Optional<ClienteModalidad> opt = repository.findById(id);
        if(!opt.isPresent())  {
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        return opt.get();
    }

    public ClienteModalidad add(ClienteModalidad obj){
        repository.save(obj);
        return obj;
    }

    public ClienteModalidad update(Long id, ClienteModalidad obj){
        Optional<ClienteModalidad> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        ClienteModalidad objUpdate = opt.get();
        repository.save(objUpdate);
        return  objUpdate;
    }

    public void delete(Long id){
        Optional<ClienteModalidad> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        repository.deleteById(id);
    }
}
