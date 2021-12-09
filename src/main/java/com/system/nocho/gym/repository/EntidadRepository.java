package com.system.nocho.gym.repository;

import com.system.nocho.gym.model.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadRepository extends JpaRepository<Entidad, Long> {
}