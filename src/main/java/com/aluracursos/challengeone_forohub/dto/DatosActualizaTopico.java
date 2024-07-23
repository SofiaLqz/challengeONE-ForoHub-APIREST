package com.aluracursos.challengeone_forohub.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizaTopico(
        String titulo,
        String mensaje,
        @JsonAlias("fecha_creacion") String fechaCreacion
) {
}
