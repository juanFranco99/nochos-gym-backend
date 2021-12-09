package com.system.nocho.gym.repository;

import com.system.nocho.gym.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}