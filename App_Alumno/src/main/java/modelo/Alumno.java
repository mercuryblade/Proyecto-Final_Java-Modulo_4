package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Params Se realiza lo evidente  para poder ser instanciados en metodos externos de esta clase que tendrán funciones importantes dentro del programa.
 */
public class Alumno {

	private String rut;
	private String nombre;
	private String apellido;
	private String direccion;
	private List<Materia> materias;
	public Alumno() {
        this.materias = new ArrayList<>(); 
    }

	public Alumno(String rut, String nombre, String apellido, String direccion) {

		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		 this.materias = new ArrayList<>(); 
	}

	public void SetRut(String rut) {

		this.rut = rut;
	}

	public void SetNombre(String nombre) {

		this.nombre = nombre;
	}

	public void SetApellido(String apellido) {
		this.apellido = apellido;

	}

	public void SetDireccion(String direccion) {

		this.direccion = direccion;
	}

	public String getNombre() {

		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public String getRut() {
		return this.rut;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public List<Materia> getMaterias() 
    { 
    	return materias; 
    	
    }
    public void setMaterias(List<Materia> materias) 
    { 
    	this.materias = materias; 
    }

}
