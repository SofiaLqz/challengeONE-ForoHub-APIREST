package com.aluracursos.challengeone_forohub.controller;

import com.aluracursos.challengeone_forohub.models.DatosMuestraTopicos;
import com.aluracursos.challengeone_forohub.models.DatosTopico;
import com.aluracursos.challengeone_forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoservicio;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosTopico datos){
        topicoservicio.registrarTopico(datos);
    }
    @GetMapping
    public Page<DatosMuestraTopicos> mostarTopicos(@PageableDefault(size=2) Pageable paginacion){
        return topicoservicio.mostarTopicos(paginacion);
    }
}
