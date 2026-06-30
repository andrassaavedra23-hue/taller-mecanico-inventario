⚙️ Taller Mecánico - Sistema de Inventario (Backend)
Proyecto de modernización de un sistema legado de escritorio hacia una arquitectura Backend moderna utilizando Java 21 y Spring Boot 3.3.1.

🛠️ Tech Stack
Java 21 (Última versión LTS)
Spring Boot 3.3.1
Spring Data JPA (Hibernate)
PostgreSQL
Maven
Docker & Docker Compose
Postman (Para pruebas de API)
🏗️ Arquitectura
El proyecto sigue el patrón de diseño estándar de Spring Boot en capas:

Entity: Modelado de datos (Repuesto.java).
Repository: Interfaz JPA para la persistencia sin SQL explícito.
Service: Capa de lógica de negocio e inyección de dependencias por constructor.
Controller: Endpoints RESTful que consumen y devuelven JSON.
🔌 Endpoints (API REST)
Método HTTP	Ruta	Descripción
POST	/api/repuestos	Crear un nuevo repuesto
GET	/api/repuestos	Listar todos los repuestos
GET	/api/repuestos/{id}	Buscar repuesto por ID
PUT	/api/repuestos/{id}	Actualizar un repuesto existente
DELETE	/api/repuestos/{id}	Eliminar un repuesto
🚀 Cómo ejecutarlo
Opción 1: Ejecución Local (Requiere tener PostgreSQL instalado)
Clonar el repositorio.
Configurar base de datos PostgreSQL en src/main/resources/application.properties.
Ejecutar la clase TallerMecanicoInventarioApplication.java.
Probar los endpoints mediante Postman en http://localhost:8080/api/repuestos.
Opción 2: Ejecución con Docker (Recomendada)
No requiere instalar nada, solo Docker Desktop.

Clonar el repositorio.
Abrir terminal en la raíz del proyecto.
Ejecutar:
docker-compose up --build
La aplicación estará disponible en http://localhost:8080/api/repuestos