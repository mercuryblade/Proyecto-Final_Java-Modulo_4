package vistas;

import java.util.Scanner;

import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;
import utilidades.Utilidad;
/**
 * @author Felipe Villegas
 * @version 1.0 Proyecto Final Modulo 4
 *@Params proyecto que permite el ingreso de datos a través de la consola con diferentes opciones, registro de alumnos, el agregar materias y calculo de promedios referentes a sus mateerias agregadas
 * @Params se incluyen todos los metodos que ocuparemos en instanciaremos en MenuTemplates.java
 */
public class Menu extends MenuTemplates {

	private final AlumnoServicio alumnoServicio = new AlumnoServicio(); 
																		
	private final ArchivoServicio archivoServicio = new ArchivoServicio();
	Scanner input = new Scanner(System.in);

	public void exportarDatos() {

		System.out.print("Ingrese la ruta para exportar los datos: ");
		String ruta = input.nextLine();
		archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
	}
	public void crearAlumno() {

		System.out.println("--- Crear Alumno ---");
		System.out.print("Ingresa RUT: ");
		String rut = input.nextLine();
		System.out.print("Ingresa nombre: ");
		String nombre = input.nextLine();
		System.out.print("Ingresa apellido: ");
		String apellido = input.nextLine();
		System.out.print("Ingresa dirección: ");
		String direccion = input.nextLine();
		alumnoServicio.crearAlumno(new Alumno(rut, nombre, apellido, direccion));
		Utilidad.mostrarMensaje("--- ¡Alumno agregado! ---");
	}
 /**
  * @Params se ocupa un sistema de validacion de acuerdo a la cantidad de materias que existen
  */
	public void agregarMateria() {
		
		System.out.println("--- Agregar Materia ---");
		System.out.print("Ingresa rut del Alumno: ");
		String rut = input.nextLine();
		if (rut.trim().isEmpty()) {
			Utilidad.mostrarMensaje("Debe ingresar un rut válido.");
			return;
		}
		Alumno alumno = alumnoServicio.listarAlumnos().get(rut);

		if (alumno == null) {
			Utilidad.mostrarMensaje("Alumno no encontrado.");
			return;
		}

		System.out.println("1. MATEMATICAS");
		System.out.println("2. LENGUAJE");
		System.out.println("3. CIENCIA");
		System.out.println("4. HISTORIA");

		int opcionMateria = obtenerOpcionValida(4);
		Materia materiaSeleccionada = new Materia();
		switch (opcionMateria) {
		case 1:
			materiaSeleccionada.setNombre(MateriaEnum.MATEMATICAS);
			break;
		case 2:
			materiaSeleccionada.setNombre(MateriaEnum.LENGUAJE);
			break;
		case 3:
			materiaSeleccionada.setNombre(MateriaEnum.CIENCIAS);
			break;
		case 4:
			materiaSeleccionada.setNombre(MateriaEnum.HISTORIA);
			break;
		}
		if (alumno.getMaterias().stream().anyMatch(m -> m.getNombre() == materiaSeleccionada.getNombre())) {
			Utilidad.mostrarMensaje("La materia ya está agregada para este alumno.");
		} else {
			alumnoServicio.agregarMateria(rut, materiaSeleccionada);
			Utilidad.mostrarMensaje("--- ¡Materia agregada! ---");
		}
	}

	private int obtenerOpcionValida(int maxOpcion) {
		int opcion;
		while (true) {
			System.out.print("Selecciona una opción (1-" + maxOpcion + "): ");
			opcion = input.nextInt();
			input.nextLine();
			if (opcion >= 1 && opcion <= maxOpcion) {
				break;
			} else {
				Utilidad.mostrarMensaje("Opción inválida. Por favor, selecciona un número entre 1 y " + maxOpcion);
			}
		}
		return opcion;
	}
 /**
  * @Params en este metodo agregamos las notas de las materias, 
  * @Params se utiliza metodo para tener tiempo suficiente de la lectura de dato retornado.
  */
	public void agregarNotaPasoUno() {
		System.out.println("--- Agregar Nota ---");
		System.out.print("Ingresa rut del Alumno: ");
		String rut = input.nextLine();
		Alumno alumno = alumnoServicio.listarAlumnos().get(rut);
		if (alumno == null) {
			Utilidad.mostrarMensaje("Alumno no encontrado.");
			return;
		}

		Utilidad.mostrarMensaje("Materias del alumno " + alumno.getNombre() + ":");
		for (int i = 0; i < alumno.getMaterias().size(); i++) {
			System.out.println((i + 1) + ". " + alumno.getMaterias().get(i).getNombre());
		}
		int materiaSeleccionada = obtenerOpcionValida(alumno.getMaterias().size());
		Materia materia = alumno.getMaterias().get(materiaSeleccionada - 1);
		System.out.print("Ingresar nota: ");
		double nota = input.nextDouble();
		input.nextLine();

		if (nota < 1 || nota > 7) {
			Utilidad.mostrarMensaje("Nota inválida. Debe estar entre 1 y 7.");
			return;
		}
		alumnoServicio.agregarNota(rut, materia.getNombre(), nota);
		Utilidad.mostrarMensaje("--- ¡Nota agregada correctamente! ---");
	}

	public void listarAlumnos() {
		Utilidad.mostrarMensaje("\n--- Listar Alumnos ---");
		alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
			Utilidad.mostrarMensaje("Datos Alumno");
			Utilidad.mostrarMensaje("RUT: " + alumno.getRut());
			Utilidad.mostrarMensaje("Nombre: " + alumno.getNombre());
			Utilidad.mostrarMensaje("Apellido: " + alumno.getApellido());
			Utilidad.mostrarMensaje("Dirección: " + alumno.getDireccion());
			Utilidad.mostrarMensaje("Materias:");
			alumno.getMaterias().forEach(materia -> {
				if (materia.getNotas().isEmpty()) {
					Utilidad.mostrarMensaje("Notas: No hay notas ingresadas.");
				} else {
					Utilidad.mostrarMensaje("Notas: " + materia.getNotas());
				}

			});
		});
	}

	public void terminarPrograma() {
		System.out.println("Saliendo del sistema");
		Utilidad.limpiarPantalla();
		System.exit(0);

	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.iniciarMenu();
	}
}
