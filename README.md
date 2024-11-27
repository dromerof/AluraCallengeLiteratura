
# 📚 El Viaje Literario 

Un sistema para la gestión, consulta de libros y autores, desarrollado como parte de un challenge de literatura. 

## 📖 Descripción

El Viaje Literario es una aplicación que integra el consumo de una API para registrar y administrar información sobre libros y autores en una base de datos local. Ofrece funcionalidades como la búsqueda de libros por título, la consulta de autores vivos en un año específico y la clasificación de libros por idioma.

## 🚀 Funcionalidades Principales

- Registro automático de libros y autores. 
- Búsqueda de libros. 
- Consulta de autores. 
- Gestión de datos.

## ⚙️ Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener listo:

- Java 17 o superior.
- Maven para la gestión de dependencias.
- PostgreSQL para la base de datos.
- Git (opcional) para clonar el repositorio.
- API para la información de libros: https://www.exchangerate-api.com/.

## 🛠️ Configuración del entorno

#### 1. Clona el repositorio

- Copia el siguiente enlace en tu terminal.
```
git clone https://github.com/tu-usuario/el-viaje-literario.git
cd el-viaje-literario
```
#### 2. Configura la base de datos

- Crea una base de datos PostgreSQL.
- Cambiar el nombre del archivo ```.example.env``` a ```.env``` y configura las credenciales en el archivo.
```
API_URL=
DB_URL=
DB_USER=
DB_PASSWORD=
```
#### 3. Instala las dependencias

-  Ejecuta el siguiente comando desde la raíz del proyecto:
```
Imvn clean install
```
#### 4. Inicia la aplicación
Ejecuta la clase ```LiteraturaApplication``` para empezar a utilizar El Viaje Literario.

## 🖥️ Uso de la Aplicación

```
1 - Búsqueda de libro por título
2 - Lista de libros registrados
3 - Lista de autores
4 - Buscar autores vivos en un determinado año
5 - Lista de libros por idioma deseado
0 - Salir
```
Ejemplo de búsqueda de libro:
![image](https://github.com/user-attachments/assets/e098b361-2367-4820-b896-8cb39579a4f7)


## 🛠️ Tecnologías utilizadas
- Java 17: Lenguaje principal.
- Spring Boot: Framework para la gestión del backend.
- Hibernate: Manejo de entidades JPA.
- PostgreSQL: Base de datos relacional.
- Dotenv: Gestión de variables de entorno.
- Maven: Gestión de dependencias.

## 👨‍💻 Autor

- [Daniel Romero](https://www.linkedin.com/in/dromerof/)
- 💼 Ingeniero de Software con pasión por el desarrollo backend.

## 📜 Licencia

Este proyecto está bajo la licencia [MIT](https://choosealicense.com/licenses/mit/)

