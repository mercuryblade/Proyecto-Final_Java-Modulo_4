# Proyecto de Gestión de Alumnos

Este proyecto tiene como objetivo la creación de una aplicación en Java para gestionar alumnos, materias, notas y exportar los datos a un archivo de texto. A través de un menú interactivo en consola, los usuarios pueden realizar diversas acciones relacionadas con el manejo de información académica.

## Funcionalidades

- **Crear Alumnos**: Permite agregar nuevos alumnos al sistema, con sus datos personales como RUT, nombre, apellido y dirección.
- **Listar Alumnos**: Muestra todos los alumnos registrados, mostrando sus detalles y las materias asignadas.
- **Agregar Materias**: Permite asignar materias a los alumnos, eligiendo entre Matemáticas, Lenguaje, Ciencia e Historia.
- **Agregar Notas**: Permite ingresar notas para las materias de los alumnos.
- **Exportar Datos**: Exporta la información de los alumnos y sus materias a un archivo de texto, permitiendo almacenar los datos fuera del sistema.

## Estructura del Proyecto

El proyecto está organizado en varios paquetes que cumplen diferentes responsabilidades:

- **`modelos`**: Contiene las clases que representan los datos del sistema, como `Alumno`, `Materia` y `MateriaEnum`.
- **`servicios`**: Incluye las clases encargadas de la lógica de negocio y la gestión de los datos, como `AlumnoServicio`, `ArchivosServicio` y `PromedioServicio`.
- **`vistas`**: Contiene la implementación del menú interactivo y la interfaz de usuario en consola.
- **`utilidades`**: Métodos auxiliares reutilizables en todo el proyecto.

## Tecnologías Utilizadas

- **Java**: El lenguaje principal utilizado para el desarrollo.
- **JUnit5**: Para realizar pruebas unitarias que aseguran el correcto funcionamiento de las funcionalidades.
- **Mockito**: Para realizar simulaciones (mocking) y pruebas de las dependencias externas del sistema.
