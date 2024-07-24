package com.aluracursos.challengeone_forohub.service;

import com.aluracursos.challengeone_forohub.dto.DatosActualizaTopico;
import com.aluracursos.challengeone_forohub.dto.DatosMuestraTopicos;
import com.aluracursos.challengeone_forohub.dto.DatosTopico;
import com.aluracursos.challengeone_forohub.models.Topico;
import com.aluracursos.challengeone_forohub.repository.ITopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private ITopicoRepository topicoRepository;
    @PostMapping
    public ResponseEntity<DatosMuestraTopicos> registrarTopico(DatosTopico datos, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datos));
        DatosMuestraTopicos topicoRespuesta = new DatosMuestraTopicos(topico);
        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(topicoRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosMuestraTopicos>> mostrarTopicos(Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosMuestraTopicos::new));
    }

    public ResponseEntity<DatosMuestraTopicos> obtenerTopico(Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()){
            Topico topicoObtenido = topico.get();
            return ResponseEntity.ok(new DatosMuestraTopicos(topicoObtenido));
        }
        return null;
    }

    public ResponseEntity<DatosMuestraTopicos> actualizarTopico(Long id, DatosActualizaTopico datos){
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            Topico topicoObtenido = topico.get();
            topicoObtenido.actualizarDatos(datos);
            return ResponseEntity.ok(new DatosMuestraTopicos(topicoObtenido));
        }
        return null;
    }

    public ResponseEntity eliminarTopico(Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()){
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return null;
    }
}
