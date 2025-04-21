package com.desoftcc.repository;

import com.desoftcc.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /// Con esto corroboramos que no existan 2 emails con los mismos valores.
    boolean existsByEmail(String email);

}
