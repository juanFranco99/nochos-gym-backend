package com.system.nocho.gym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "entidad")
@Entity
@Getter
@Setter
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ruc_ci", nullable = false)
    private String rucCi;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "proveedor", length = 1)
    private String proveedor;

    @Column(name = "cliente", length = 1)
    private String cliente;

}