package com.aluracursos.challengeone_forohub.dto;

import com.aluracursos.challengeone_forohub.models.Topico;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DatosMuestraTopicos (
        Long id,
        String titulo,
        String mensaje,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime fechaCreacion,
        String status,
        Integer autor,
        Integer curso
) {
    public DatosMuestraTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }

}
