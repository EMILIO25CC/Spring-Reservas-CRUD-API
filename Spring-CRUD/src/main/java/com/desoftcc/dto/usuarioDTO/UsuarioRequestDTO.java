package com.desoftcc.dto.usuarioDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder /// Esto es para crear los objetos más rápido. (Es necesario SETTER para realizar las actualizaciones del objeto que incluye @Data de Lombok)
public class UsuarioRequestDTO {

    /// Esto escribirá el usuario en el formúlario.
    // [POST]

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 50)
    private String nombreCompleto;

    @Email
    @NotBlank(message = "El Email es obligatorio.")
    private String email;

    @NotBlank(message = "El teléfono es obligatorio.")
    @Pattern(regexp = "\\d {9}", message = "El teléfono debe contar con 9 dígitos.")
    private String telefono;

    private String departamento;

    //private String password;


    //_________________________________________________

   /*

    El objetivo de los DTO es que se puedan realizar transferencias de datos
    entre las distintas capas de la aplicación (controlador, servicio, repositorio)
    sin exponer directamente las entidades de la base de datos.

    Response:
    - Es el DTO que se usa para devolver información al cliente (ejemplo: al front-end).
    - Contiene los datos que queremos mostrar, incluso puede omitir atributos sensibles
      como contraseñas o información interna de la base de datos.

    Request:
    - Es el DTO que se usa para recibir datos del cliente (ejemplo: al registrar un usuario).
    - Contiene solamente los campos que el cliente debe enviar, sin exponer detalles de
      cómo funciona la entidad en la base de datos.



    _____________________________________________________________

     1. El backend siempre debe ser la fuente de verdad y seguridad
        Si solo dependes del frontend para ocultar datos, en realidad los datos siguen viajando desde el backend al cliente.
        Ejemplo: tu API devuelve el objeto Usuario completo (incluyendo contraseña, token, rol interno). El frontend “decide” mostrar solo nombre y email.
        Un usuario curioso abre Developer Tools → Network y ve toda la respuesta JSON, incluso lo que no se muestra en pantalla. ⚠️
        Resultado: tu seguridad queda comprometida porque sí enviaste la información.

    */

    // [ DATA TRANSFER OBJET ]

}/// FIN
