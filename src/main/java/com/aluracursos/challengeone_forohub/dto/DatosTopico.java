package com.aluracursos.challengeone_forohub.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Record para recibir los datos
public record DatosTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        @JsonAlias("fecha_creacion") String fechaCreacion,
        @NotBlank
        String status,
        @NotNull
        Integer autor,
        @NotNull
        Integer curso
) {
}
