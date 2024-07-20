package com.aluracursos.challengeone_forohub.controller;

import com.aluracursos.challengeone_forohub.models.DatosMuestraTopicos;
import com.aluracursos.challengeone_forohub.models.DatosTopico;
import com.aluracursos.challengeone_forohub.models.Topico;
import com.aluracursos.challengeone_forohub.repository.ITopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private ITopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosTopico datos){
        topicoRepository.save(new Topico(datos));
        System.out.println(datos);
    }
    @GetMapping
    public List<DatosMuestraTopicos> mostarTopicos(){
        return topicoRepository.findAll().stream().map(DatosMuestraTopicos::new).toList();
    }
}
