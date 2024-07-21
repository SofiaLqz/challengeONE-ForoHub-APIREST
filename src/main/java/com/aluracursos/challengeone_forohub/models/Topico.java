package com.aluracursos.challengeone_forohub.models;

import com.aluracursos.challengeone_forohub.dto.DatosTopico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime fechaCreacion;
    private String status;
    private Integer autor;
    private Integer curso;


    public Topico(DatosTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.parse(datos.fechaCreacion(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.status = datos.status();
        this.autor = datos.autor();
        this.curso = datos.curso();
    }
}
