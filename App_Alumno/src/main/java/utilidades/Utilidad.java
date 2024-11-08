package utilidades;

/**
 * 
 * @Params Utilidad básica solo para tener mejor lectura de los datos ingresados en consola
 */
public class Utilidad {

		
		public static void saltarLinea() {
			
			
		 System.out.println("\n\n");
		 
		 /**
		  * @Params metodo que servira para dar tiempo de lectura de respuesta de la consola que además es modificable en su tiempo.
		  */
		}
		 public static void mostrarMensaje(String mensaje) {
		        System.out.println(mensaje);
		        try {
		            Thread.sleep(2000);
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		        }
		    }
		 public static void limpiarPantalla() {
		        System.out.print("\033[H\033[2J");
		        System.out.flush();
		    }

}
