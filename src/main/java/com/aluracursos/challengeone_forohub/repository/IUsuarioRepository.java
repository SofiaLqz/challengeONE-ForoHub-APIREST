package com.aluracursos.challengeone_forohub.repository;

import com.aluracursos.challengeone_forohub.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByNombre(String username);
}
