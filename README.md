# 🏢 Sistema de Reservas - CRUD con Spring Boot

Un sistema completo de gestión de reservas desarrollado con **Spring Boot**, que permite administrar usuarios, salas y reservas a través de una API REST robusta y bien estructurada.

## 📋 Descripción del Proyecto

Este proyecto implementa un **CRUD completo** para un sistema de reservas con **3 entidades principales** relacionadas:

- **👤 Usuario**: Gestión de usuarios del sistema
- **🏠 Sala**: Administración de salas disponibles
- **📅 Reserva**: Sistema de reservas con validación de disponibilidad

### 🎯 Características Principales

- ✅ **API REST completa** con operaciones CRUD para todas las entidades
- 🔄 **DTOs (Data Transfer Objects)** para separación de capas
- 🛡️ **Validaciones de negocio** (prevención de solapamiento de reservas)
- 🏗️ **Arquitectura limpia** con separación de responsabilidades
- 📚 **Documentación integrada** en el código
- 🧪 **Probado con Postman**

---

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| ☕ **Java** | 17 | Lenguaje de programación |
| ⚡ **Spring Boot** | 3.x | Framework principal |
| 🗄️ **Spring Data JPA** | - | Persistencia de datos |
| 🐬 **MySQL** | 8.x | Base de datos |
| 🔧 **Lombok** | - | Reducción de código boilerplate |
| 📬 **Postman** | - | Testing de API |

---

## 📂 Estructura del Proyecto

```
src/main/java/com/desoftcc/
├── 🎮 controller/          # Controladores REST
│   ├── ReservaController.java
│   ├── SalaController.java
│   └── UsuarioController.java
│
├── 📦 dto/                 # Data Transfer Objects
│   ├── reservaDTO/
│   │   ├── ReservaRequestDTO.java
│   │   └── ReservaResponseDTO.java
│   ├── salaDTO/
│   └── usuarioDTO/
│
├── 🏢 entity/              # Entidades JPA
│   ├── Reserva.java
│   ├── Sala.java
│   └── Usuario.java
│
├── 🗺️ mapper/              # Mappers para DTOs
│   ├── reserva/
│   ├── sala/
│   └── usuario/
│
├── 🗄️ repository/          # Repositorios JPA
│
├── ⚙️ service/             # Lógica de negocio
│   │   ├── ReservaService.java
│   │   ├── SalaService.java
│   │   └── UsuarioService.java
|   ├── impl/
|        ├── ReservaServiceImp.java 
│        ├── SalaServiceImp.java
|        └── UsuarioServiceImp.java
|
└── 📱 SpringCrudApplication.java
```

---

## 🗃️ Modelo de Base de Datos

### Relaciones entre Entidades

```
Usuario (1) -----> (*) Reserva (*) <----- (1) Sala
```

- Un **Usuario** puede tener múltiples **Reservas**
- Una **Sala** puede tener múltiples **Reservas**
- Una **Reserva** pertenece a un **Usuario** y una **Sala**

### Entidades Principales

#### 👤 Usuario
- ID único
- Información personal
- Relación uno-a-muchos con Reservas

#### 🏠 Sala
- ID único
- Detalles de la sala
- Relación uno-a-muchos con Reservas

#### 📅 Reserva
- ID único
- Fecha y hora de reserva
- Referencias a Usuario y Sala

---

## 🚀 Instalación y Configuración

### Prerequisitos

- ☕ Java 17 o superior
- 🐬 MySQL 8.x
- 🛠️ Maven 3.6+

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/spring-crud-reservas.git
   cd spring-crud-reservas
   ```

2. **Configurar la base de datos**
   ```sql
   CREATE DATABASE reservas_db;
   ```

3. **Configurar application.properties**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/reservas_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Ejecutar el proyecto**
   ```bash
   mvn spring-boot:run
   ```

---

## 📡 Endpoints de la API

### 👤 Usuarios
- `GET /usuarios` - Listar todos los usuarios
- `GET /usuarios/{id}` - Obtener usuario por ID
- `POST /usuarios` - Crear nuevo usuario
- `PUT /usuarios/{id}` - Actualizar usuario
- `DELETE /usuarios/{id}` - Eliminar usuario

### 🏠 Salas
- `GET /salas` - Listar todas las salas
- `GET /salas/{id}` - Obtener sala por ID
- `POST /salas` - Crear nueva sala
- `PUT /salas/{id}` - Actualizar sala
- `DELETE /salas/{id}` - Eliminar sala

### 📅 Reservas
- `GET /reservas` - Listar todas las reservas
- `GET /reservas/{id}` - Obtener reserva por ID
- `POST /reservas` - Crear nueva reserva
- `PUT /reservas/{id}` - Actualizar reserva
- `DELETE /reservas/{id}` - Eliminar reserva

---

## 🧪 Pruebas con Postman

El proyecto incluye validaciones para:

- ✅ Verificación de disponibilidad de salas
- ✅ Prevención de solapamiento de horarios
- ✅ Validación de datos de entrada
- ✅ Manejo de errores y excepciones

### Ejemplo de Request - Crear Reserva

```json
{
    "usuarioId": 1,
    "salaId": 1,
    "fechaInicio": "2024-12-01T10:00:00",
    "fechaFin": "2024-12-01T12:00:00",
    "descripcion": "Reunión de equipo"
}
```

---

## 🏗️ Arquitectura del Proyecto

### Patrón de Capas Implementado

1. **🎮 Controller Layer**: Manejo de requests HTTP
2. **⚙️ Service Layer**: Lógica de negocio
3. **🗄️ Repository Layer**: Acceso a datos
4. **🏢 Entity Layer**: Modelos de dominio
5. **📦 DTO Layer**: Objetos de transferencia

### Principios Aplicados

- **Separation of Concerns**: Cada capa tiene una responsabilidad específica
- **Dependency Injection**: Gestión automática de dependencias con Spring
- **Data Transfer Objects**: Separación entre modelo de dominio y API

---

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Para contribuir:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

---

## 📝 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

---

## 👨‍💻 Autor

**Tu Nombre**
- GitHub: [@tu-usuario](https://github.com/tu-usuario)
- LinkedIn: [Tu Perfil](https://linkedin.com/in/tu-perfil)

---

## 📞 Soporte

¿Tienes preguntas o sugerencias? 

- 📧 Email: tu-email@ejemplo.com
- 🐛 Issues: [GitHub Issues](https://github.com/tu-usuario/spring-crud-reservas/issues)

---

*⭐ Si te gusta este proyecto, no olvides darle una estrella en GitHub*
