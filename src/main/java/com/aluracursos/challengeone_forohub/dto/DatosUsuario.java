package com.aluracursos.challengeone_forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String contrasenia,
        Integer perfiles
) {
}
