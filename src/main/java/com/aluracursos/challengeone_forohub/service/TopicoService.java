package com.aluracursos.challengeone_forohub.service;

import com.aluracursos.challengeone_forohub.dto.DatosActualizaTopico;
import com.aluracursos.challengeone_forohub.dto.DatosMuestraTopicos;
import com.aluracursos.challengeone_forohub.dto.DatosTopico;
import com.aluracursos.challengeone_forohub.models.Topico;
import com.aluracursos.challengeone_forohub.repository.ITopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private ITopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(DatosTopico datos){
        topicoRepository.save(new Topico(datos));
    }
    @GetMapping
    public Page<DatosMuestraTopicos> mostrarTopicos(Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosMuestraTopicos::new);
    }

    public DatosMuestraTopicos obtenerTopico(Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()){
            Topico topicoObtenido = topico.get();
            return new DatosMuestraTopicos(topicoObtenido);
        }
        return null;
    }

    public void actualizarTopico(DatosActualizaTopico datos){
        Topico topico = topicoRepository.getReferenceById(datos.id());
        topico.actualizarDatos(datos);
    }
}
