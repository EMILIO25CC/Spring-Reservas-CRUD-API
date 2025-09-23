## Spring Reservas CRUD API

Proyecto de práctica para aprender **Spring Boot** con un CRUD completo que maneja 3 entidades relacionadas: Usuario, Sala y Reserva.

## ¿Qué hace?

Sistema básico donde:
- Los **usuarios** pueden hacer **reservas** de **salas**
- Cada reserva tiene fecha/hora y evita solapamientos
- API REST para todas las operaciones CRUD

## Tecnologías

- **Java 17** + **Spring Boot 3**
- **MySQL** para la base de datos
- **Spring Data JPA** para persistencia
- **Lombok** para reducir código repetitivo

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
│   ├── impl/
│        ├── ReservaServiceImp.java 
│        ├── SalaServiceImp.java
│        └── UsuarioServiceImp.java
│
└── 📱 SpringCrudApplication.java
```

## 🗃️ Base de Datos

**Relaciones:**
- Usuario (1) → Reservas (N)
- Sala (1) → Reservas (N)
- Reserva pertenece a 1 Usuario y 1 Sala

## Cómo usar

1. **Clonar y configurar MySQL:**
   ```bash
   git clone https://github.com/EMILIO25CC/CRUD-Spring-3-Tbl.git
   # Crear BD: reservadb
   ```

2. **Configurar application.properties:**
   ```properties
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/reservadb
       username: tu_usuario
       password: tu_password
       driver-class-name: com.mysql.cj.jdbc.Driver
   
     jpa:
       hibernate:
         ddl-auto: update
       show-sql: true
       properties:
         hibernate:
           dialect: org.hibernate.dialect.MySQL8Dialect
           format_sql: true
           use_sql_comments: true
   server:
     port: 8080
   ```

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

## 🧪 Probado con Postman

Incluye validación básica para evitar reservas solapadas en la misma sala.

---

**Proyecto de práctica para aprender Spring Boot y relaciones JPA** 🚀
