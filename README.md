# PWeb Backend Library

Backend REST para la gestión de una biblioteca. El proyecto expone una API construida con Spring Boot para administrar libros, autores, clientes, copias, préstamos, solicitudes de préstamo, usuarios, roles, sanciones y materias.

## Características

- API REST organizada por controladores, servicios, repositorios, entidades y DTOs.
- Persistencia con PostgreSQL y Spring Data JPA.
- Autenticación y autorización basada en Spring Security y tokens JWT.
- Documentación de la API con OpenAPI/Swagger.
- Mapeo entre entidades y DTOs con MapStruct.
- Envío de correos con Spring Mail y plantillas FreeMarker.
- Empaquetado como aplicación WAR para despliegue en Tomcat.

## Tecnologías

- Java 8
- Spring Boot 2.7.5
- Spring Web
- Spring Data JPA / Hibernate
- PostgreSQL
- Spring Security
- JWT
- MapStruct
- SpringDoc OpenAPI
- Maven

## Estructura del proyecto

```text
src/main/java/cu/edu/cujae/pwebbackend/
├── config/              # Configuración de seguridad y FreeMarker
├── domain/
│   ├── dto/             # Objetos de transferencia
│   ├── email/           # Servicios y modelos de correo
│   ├── repository/      # Interfaces de acceso al dominio
│   ├── security/        # Autenticación, JWT y usuarios
│   └── service/         # Lógica de negocio
├── persistence/
│   ├── crud/            # Repositorios Spring Data
│   ├── entity/          # Entidades JPA
│   ├── mapper/          # MapStruct
│   └── utils/           # Claves compuestas y utilidades
└── web/
    ├── controller/      # Endpoints REST
    └── exception/       # Manejo global de excepciones
```

## Requisitos

- JDK 8
- PostgreSQL
- Maven 3.6+ o el Maven Wrapper incluido
- Una cuenta SMTP si se desea probar el envío de correos

## Configuración local

1. Crea una base de datos PostgreSQL para la aplicación.
2. Revisa los perfiles de configuración en `src/main/resources`:
   - `application-dev.properties`
   - `application-pdn.properties`
3. Configura las credenciales de base de datos y correo mediante variables de entorno o un archivo local que no se publique.
4. Importa el respaldo disponible en `database/DB_Library.backup` si necesitas datos iniciales.
5. Activa el perfil correspondiente:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

En Windows:

```powershell
mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=dev
```

La aplicación utiliza el contexto `/pweb-backend-library`. El puerto puede ajustarse en la configuración del perfil activo.

## Compilar y probar

```bash
./mvnw clean verify
```

Para generar el artefacto WAR:

```bash
./mvnw clean package
```

El archivo generado se encuentra en `target/`.

## Documentación de la API

Con la aplicación ejecutándose, revisa la documentación OpenAPI en las rutas estándar de SpringDoc:

- `/pweb-backend-library/swagger-ui.html`
- `/pweb-backend-library/v3/api-docs`

## Seguridad

No publiques contraseñas, tokens ni credenciales SMTP en el repositorio. Usa variables de entorno o un gestor de secretos y revoca cualquier credencial que haya sido expuesta anteriormente.

## Estado del proyecto

Proyecto académico de programación web enfocado en el diseño de una API para la gestión de bibliotecas.
