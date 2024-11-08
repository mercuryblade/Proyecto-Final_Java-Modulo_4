package servicios;

import java.util.List;

public class PromedioServicioImp {

	
	public double calcularPromedio( List<Double> valores) {
		
		return valores.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
	}
	
}
