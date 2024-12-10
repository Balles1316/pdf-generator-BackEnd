# Generador de Partes de Trabajo - Backend API REST

Este proyecto consiste en un backend desarrollado en **Java**, utilizando el framework **Spring Boot**, para la generación y gestión de partes de trabajo en entornos empresariales. La aplicación proporciona una API REST que facilita la integración con sistemas de frontend o herramientas externas, permitiendo gestionar información de manera eficiente.

## Tecnologías utilizadas

- **Lenguaje**: Java 17 o superior.
- **Framework principal**: Spring Boot 3.x.
- **Base de datos**: Microsoft SQL Server.
- **Gestor de dependencias**: Maven.
- **Conexión a la base de datos**: HikariCP.
- **Manejo de entidades**: JPA/Hibernate.
- **Servidor embebido**: Apache Tomcat.
- **Seguridad**: Spring Security (si aplica).

## Funcionalidades principales

- **Gestín de partes de trabajo:**
  - Creación, edición, eliminación y consulta de partes de trabajo.
  - Gestión de información como clientes, empleados, tareas y estados de los trabajos.
- **API REST estructurada:** Endpoints organizados para operaciones CRUD.
- **Configuración flexible:**
  - Variables de entorno o configuración a través del archivo `application.properties`.
- **Manejo de errores:** Implementación de respuestas estándar para errores comunes como datos faltantes o problemas de conexión.
- **Escalabilidad:** Diseñado para admitir integración con sistemas frontend o aplicaciones móviles.

## Endpoints principales

### Partes de trabajo

| Método | Endpoint               | Descripción                          |
|--------|------------------------|--------------------------------------|
| GET    | `/api/partes`          | Listar todos los partes de trabajo. |
| GET    | `/api/partes/{id}`     | Obtener un parte de trabajo por ID. |
| POST   | `/api/partes`          | Crear un nuevo parte de trabajo.    |
| PUT    | `/api/partes/{id}`     | Actualizar un parte de trabajo.     |
| DELETE | `/api/partes/{id}`     | Eliminar un parte de trabajo.       |

### Empleados

| Método | Endpoint                  | Descripción                              |
|--------|---------------------------|------------------------------------------|
| GET    | `/api/empleados`          | Listar todos los empleados.             |
| GET    | `/api/empleados/{id}`     | Obtener un empleado por ID.             |
| POST   | `/api/empleados`          | Crear un nuevo empleado.                |
| PUT    | `/api/empleados/{id}`     | Actualizar información de un empleado.   |
| DELETE | `/api/empleados/{id}`     | Eliminar un empleado.                   |

(Otros endpoints pueden ser definidos según los requisitos del proyecto.)

## Configuración del proyecto

### Requisitos previos

1. **Java 17 o superior**
2. **Apache Maven**
3. **Microsoft SQL Server** (puerto por defecto: `1433`)
4. Configurar el entorno con las siguientes variables:
   - `spring.datasource.url`: URL de conexión a la base de datos (por ejemplo, `jdbc:sqlserver://{host}:{port};databaseName={nombreBaseDatos}`).
   - `spring.datasource.username`: Usuario de la base de datos.
   - `spring.datasource.password`: Contraseña de la base de datos.

### Ejecución local

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tuusuario/generador-partes-trabajo.git
   cd generador-partes-trabajo
   ```

2. Configurar las propiedades de la base de datos en `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=gestion_servicios
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. Ejecutar el proyecto:
   ```bash
   mvn spring-boot:run
   ```

4. Acceder a la aplicación:
   - Documentación API Swagger: `http://localhost:8080/swagger-ui/index.html`
   - API REST disponible en `http://localhost:8080/api`

## Estructura del proyecto

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── axiome
│   │   │           └── generadorpartetrabajo
│   │   │               ├── controllers    # Controladores REST
│   │   │               ├── models         # Entidades y modelos de datos
│   │   │               ├── repositories   # Repositorios JPA
│   │   │               ├── services       # Servicios de negocio
│   │   │               └── GeneradorParteTrabajoApplication.java
│   │   └── resources
│   │       ├── application.properties     # Configuración de la aplicación
│   │       └── data.sql                   # Datos iniciales (si aplica)
├── pom.xml                                # Dependencias del proyecto
```

## Dependencias principales

Las dependencias más relevantes utilizadas en el proyecto son:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.microsoft.sqlserver</groupId>
        <artifactId>mssql-jdbc</artifactId>
        <version>12.6.4.jre11</version>
    </dependency>
    <dependency>
        <groupId>com.zaxxer</groupId>
        <artifactId>HikariCP</artifactId>
    </dependency>
</dependencies>
```

## Problemas comunes

1. **Error de conexión a la base de datos:**
   - Verifica que el servidor SQL esté corriendo y que el puerto `1433` esté abierto.
   - Asegúrate de que las credenciales y el nombre de la base de datos sean correctos.

2. **Errores de dependencias:**
   - Ejecuta `mvn clean install` para asegurarte de que todas las dependencias estén correctamente descargadas.

3. **El puerto 8080 ya está en uso:**
   - Cambia el puerto en `application.properties`:
     ```properties
     server.port=8081
     ```

## Contribuciones

Si deseas contribuir a este proyecto:

1. Haz un fork del repositorio.
2. Crea una nueva rama con tu función o corrección: `git checkout -b feature/nueva-funcion`.
3. Envía un pull request con los cambios.

## Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).

