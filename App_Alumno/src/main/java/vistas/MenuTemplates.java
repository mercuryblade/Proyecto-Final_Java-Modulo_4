package vistas;

import java.util.Scanner;
/**
 * @Params Metodo de un menu clasico con switch, con funcionamiento básico.
 */
public abstract class MenuTemplates {

	public abstract void exportarDatos();

	public abstract void crearAlumno();
	public abstract void agregarMateria();
	public abstract void agregarNotaPasoUno();
	public abstract void listarAlumnos();
	public abstract void terminarPrograma();
	Scanner input = new Scanner(System.in);
	public void iniciarMenu() {

		
		boolean salir = false;

		while (!salir) {

			System.out.println("\nMenú Principal:");
			System.out.println("1. Crear Alumno");
			System.out.println("2. Listar Alumnos");
			System.out.println("3. Agregar Materia");
			System.out.println("4. Agregar Notas");
			System.out.println("5. Salir");
			System.out.println("6. Exportar Datos");
			System.out.print("\nSeleccione una opción: ");
			int opcion = input.nextInt();
			input.nextLine();
			switch (opcion) {

			case 1:
				crearAlumno();
				break;
			case 2:
				listarAlumnos();
				break;
			case 3:
				agregarMateria();
				break;
			case 4:
				agregarNotaPasoUno();
				break;
			case 5:
				salir = true;
				break;
			case 6:
				exportarDatos();
				break;
			default:
				break;

			}
		}
	}

}
