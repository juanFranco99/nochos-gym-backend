package com.system.nocho.gym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "modalidad")
@Entity
@Getter
@Setter
public class Modalidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modalidad", nullable = false)
    private Long id;

    @Column(name = "modalidad", nullable = false)
    private String modalidad;

    @Column(name = "precio", precision = 131089)
    private BigDecimal precio;

}