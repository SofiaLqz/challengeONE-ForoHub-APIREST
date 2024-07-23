package com.aluracursos.challengeone_forohub.controller;

import com.aluracursos.challengeone_forohub.dto.DatosActualizaTopico;
import com.aluracursos.challengeone_forohub.dto.DatosMuestraTopicos;
import com.aluracursos.challengeone_forohub.dto.DatosTopico;
import com.aluracursos.challengeone_forohub.service.TopicoService;
import jakarta.transaction.Transactional;
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
    public Page<DatosMuestraTopicos> mostrarTopicos(@PageableDefault(size=2) Pageable paginacion){
        return topicoservicio.mostrarTopicos(paginacion);
    }
    @GetMapping("/{id}")
    public DatosMuestraTopicos obtenerTopico(@PathVariable Long id){
        return topicoservicio.obtenerTopico(id);
    }
    @PutMapping("/{id}")
    @Transactional
    public void actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizaTopico datos){
        topicoservicio.actualizarTopico(id, datos);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        topicoservicio.eliminarTopico(id);
    }
}
