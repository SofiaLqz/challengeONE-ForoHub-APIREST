package com.aluracursos.challengeone_forohub.dto;

public record DatosUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        String contrasenia,
        Integer perfiles
) {
}
