package com.system.nocho.gym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "producto")
@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Long id;

    @Column(name = "codigo", precision = 131089)
    private Long codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "cantidad", precision = 131089)
    private BigDecimal cantidad;

    @Column(name = "precio", precision = 131089)
    private BigDecimal precio;

}