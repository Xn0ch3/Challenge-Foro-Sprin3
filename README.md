# 🧑‍💻 Challenge Foro Spring3

![Logo del Proyecto](https://github.com/Xn0ch3/Challenge-Foro-Spring3/raw/main/assets/Challenge-Foro-Sprin3.png)

**Descripción:**
Este proyecto es una implementación de un foro en línea utilizando **Spring Boot 3**, **Spring Security**, **JPA/Hibernate** y **JWT** para la autenticación. Permite a los usuarios registrarse, iniciar sesión y participar en discusiones sobre diversos temas.

---

## 🚀 Tecnologías Utilizadas

* **Backend:**

  * Java 17
  * Spring Boot 3
  * Spring Security
  * Spring Data JPA
  * Hibernate
  * JWT (JSON Web Tokens)
  * BCrypt para encriptación de contraseñas

* **Base de Datos:**

  * MySQL 8.0 (Dockerizado)

* **Herramientas de Desarrollo:**

  * Maven
  * Docker
  * Postman para pruebas de API

---

## 🔧 Instalación y Configuración

### Requisitos Previos

* [JDK 17](https://adoptopenjdk.net/) o superior
* [Docker](https://www.docker.com/get-started) (opcional, para base de datos)
* [Postman](https://www.postman.com/) para pruebas de API

### Pasos para Ejecutar el Proyecto

1. **Clonar el Repositorio:**

   ```bash
   git clone https://github.com/Xn0ch3/Challenge-Foro-Sprin3.git
   cd Challenge-Foro-Sprin3
   ```

2. **Compilar y Ejecutar la Aplicación:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   La aplicación se ejecutará en `http://localhost:8080`.

3. **Configurar la Base de Datos (opcional):**

   Si prefieres usar Docker para la base de datos:

   ```bash
   docker-compose up -d
   ```

   Esto levantará un contenedor con MySQL 8.0 accesible en `localhost:3306`.

---

## 🧪 Endpoints Principales

### 🔐 Autenticación

* **POST** `/login`: Inicia sesión y obtiene un token JWT.

  **Body:**

  ```json
  {
    "email": "usuario@example.com",
    "password": "tu_contraseña"
  }
  ```

  **Respuesta:**

  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
  }
  ```

### 👤 Gestión de Usuarios

* **POST** `/usuarios`: Registra un nuevo usuario.

  **Body:**

  ```json
  {
    "nombre": "Juan Pérez",
    "email": "juan@example.com",
    "password": "contraseña_segura"
  }
  ```

### 📚 Gestión de Tópicos

* **GET** `/topicos`: Obtiene la lista de tópicos.

* **POST** `/topicos?usuarioId={id}`: Crea un nuevo tópico.

  **Body:**

  ```json
  {
    "titulo": "Problema con Spring Boot",
    "mensaje": "No puedo conectar a la base de datos",
    "curso": "Spring Boot"
  }
  ```

  **Headers:**

  ```http
  Authorization: Bearer {tu_token_jwt}
  ```

* **DELETE** `/topicos/{id}`: Elimina un tópico por ID.

---

## 📦 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── alura/
│   │           └── challengeforo/
│   │               ├── controller/
│   │               ├── dto/
│   │               ├── models/
│   │               ├── repository/
│   │               └── service/
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── alura/
                └── challengeforo/
                    └── tests/
```

---

## 🧪 Pruebas con Postman

Puedes importar la colección de Postman desde el siguiente enlace:

👉 [Descargar colección de Postman](https://github.com/Xn0ch3/Challenge-Foro-Sprin3/raw/main/assets/Challenge-Foro-Spring3.postman_collection.json)

---

## 📸 Captura de Pantalla

![Interfaz del Foro](https://github.com/Xn0ch3/Challenge-Foro-Sprin3/raw/main/assets/foro-spring3-interface.png)

---

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](https://github.com/Xn0ch3/Challenge-Foro-Sprin3/blob/main/LICENSE) para más detalles.

---

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar este proyecto, por favor:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

---

## 📞 Contacto

GitHub: @Xn0ch3
LinkedIn: [https://www.linkedin.com/in/xavier-nochelli/]
Email: XavierNochelli@Gmail.com



