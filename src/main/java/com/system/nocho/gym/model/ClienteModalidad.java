package com.system.nocho.gym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "cliente_modalidad")
@Entity
@Getter
@Setter
public class ClienteModalidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_entidad")
    private Entidad entidad;

    @ManyToOne
    @JoinColumn(name = "id_modalidad")
    private Modalidad modalidad;

}