package com.aluracursos.challengeone_forohub.controller;

import com.aluracursos.challengeone_forohub.models.DatosTopico;
import com.aluracursos.challengeone_forohub.models.Topico;
import com.aluracursos.challengeone_forohub.repository.ITopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
