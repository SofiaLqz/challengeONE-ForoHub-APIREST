package com.aluracursos.challengeone_forohub.service;

import com.aluracursos.challengeone_forohub.models.DatosMuestraTopicos;
import com.aluracursos.challengeone_forohub.models.DatosTopico;
import com.aluracursos.challengeone_forohub.repository.ITopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class TopicoService {
    @Autowired
    private ITopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(DatosTopico datos){
    }
    @GetMapping
    public Page<DatosMuestraTopicos> mostarTopicos(Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosMuestraTopicos::new);
    }
}
