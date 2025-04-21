package com.desoftcc.service.Imp;

import com.desoftcc.dto.usuarioDTO.UsuarioRequestDTO;
import com.desoftcc.dto.usuarioDTO.UsuarioResponseDTO;
import com.desoftcc.entity.Usuario;
import com.desoftcc.mapper.usuario.UsuarioMapper;
import com.desoftcc.repository.UsuarioRepository;
import com.desoftcc.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@RequiredArgsConstructor
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioMapper mapper;
    private final UsuarioRepository repository;


    @Override
    public List<UsuarioResponseDTO> Listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public UsuarioResponseDTO Guardar(UsuarioRequestDTO requestDTO) {
      if(repository.existsByEmail(requestDTO.getEmail())){
          throw new RuntimeException("El email ya está registrado");
      }
        Usuario usuario = mapper.toEntity(requestDTO);
        Usuario usuarioGuardado = repository.save(usuario);
        return mapper.toDTO(usuarioGuardado);
    }



    @Override
    public UsuarioResponseDTO ObtenerPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException(("Usuario no encontrado")));
    }

    @Override
    public void Eliminar(Long id) {
    if(!repository.existsById(id)){
        throw new RuntimeException("No existe un Usuario con Id:"+ id);
    }
    repository.deleteById(id);
    }

    @Override
    public Usuario obtenerEntidadPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }
}
