package com.desoftcc.repository;

import com.desoftcc.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /// Con esto corroboramos que no existan 2 Email igual.
    ///
    ///  Este metodo JPA lo entiende como una Query de búsqueda,
    ///
    /// siempre y cuando se use estrictamente el metodo ( existsByEmail )
    ///
    /// Se tiene que usar esa tipografía y caracteres específicos.

    boolean existsByEmail(String email);


}//FIN