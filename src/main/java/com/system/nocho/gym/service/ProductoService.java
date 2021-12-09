package com.system.nocho.gym.service;

import com.system.nocho.gym.exception.RecursoNoEncontradoException;
import com.system.nocho.gym.model.Producto;
import com.system.nocho.gym.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public List<Producto> finAll(){
        return repository.findAll();
    }

    public Producto getById(Long id){
        Optional<Producto> opt = repository.findById(id);
        if(!opt.isPresent())  {
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        return opt.get();
    }

    public Producto add(Producto obj){
        repository.save(obj);
        return obj;
    }

    public Producto update(Long id, Producto obj){
        Optional<Producto> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        Producto objUpdate = opt.get();
        repository.save(objUpdate);
        return  objUpdate;
    }

    public void delete(Long id){
        Optional<Producto> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new RecursoNoEncontradoException(String.format("El genero con el id %s no fue encontrado", id));
        }
        repository.deleteById(id);
    }
}
