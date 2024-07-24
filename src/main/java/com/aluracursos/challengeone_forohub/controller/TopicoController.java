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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoservicio;
    // Registrar un tópico
    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosTopico datos,
                                          UriComponentsBuilder uriComponentsBuilder){
        return topicoservicio.registrarTopico(datos, uriComponentsBuilder);
    }
    // Mostrar todos los tópicos
    @GetMapping
    public ResponseEntity<Page<DatosMuestraTopicos>> mostrarTopicos(@PageableDefault(size=2) Pageable paginacion){
        return topicoservicio.mostrarTopicos(paginacion);
    }
    // Mostrar un tópico
    @GetMapping("/{id}")
    public ResponseEntity<DatosMuestraTopicos> obtenerTopico(@PathVariable Long id){
        return topicoservicio.obtenerTopico(id);
    }
    // Actualizar un tópico
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizaTopico datos){
        return topicoservicio.actualizarTopico(id, datos);
    }
    // Eliminar un tópico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        return topicoservicio.eliminarTopico(id);
    }
}
