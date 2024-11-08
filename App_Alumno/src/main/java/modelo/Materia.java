package modelo;


import java.util.ArrayList;
import java.util.List;

/**
 * @Params Se decide trabajar con List ya que permite datos repetidos contrario a Set
 */
public class Materia {

	private MateriaEnum nombre;
	private List<Double> notas = new ArrayList<>();
	
	public MateriaEnum getNombre() {
		return nombre;
	}
	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	public Materia() {
		
		this.notas = new ArrayList<>();
	}
	
}
