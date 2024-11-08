package servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @Params Se ocupara para solamente probar la entrada de datos tipo double y que pudieran devolver un promedio.
 */
public class PromedioServicioImpTest {

	
	@Test
	public void calcularPromedioTest() {
		
		PromedioServicioImp promedioTest = new PromedioServicioImp();
		
		List<Double> valores = Arrays.asList(10.0, 20.0, 30.0);
		double promedio = promedioTest.calcularPromedio(valores);
		assertEquals(20.0, promedio, 0.001);
	}
}
