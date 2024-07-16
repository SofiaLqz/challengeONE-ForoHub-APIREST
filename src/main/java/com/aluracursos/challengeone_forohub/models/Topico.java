package com.aluracursos.challengeone_forohub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Clase para hacer la persistencia de datos en la base de datos
@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    //private LocalDate fechaCreacion;
    private String status;
    private Integer autor;
    private Integer curso;


    public Topico(DatosTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        //this.fechaCreacion = LocalDate.parse(datos.fechaCreacion());
        this.status = datos.status();
        this.autor = datos.autor();
        this.curso = datos.curso();
    }
}
