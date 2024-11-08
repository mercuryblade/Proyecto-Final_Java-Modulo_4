package servicios;

import modelo.Alumno;
import modelo.Materia;
import utilidades.Utilidad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ArchivoServicio {

    private PromedioServicioImp promedioServicioImp = new PromedioServicioImp();


    public void exportarDatos(Map<String, Alumno> alumnos, String rutaArchivo) {
        try {

            if (!Files.exists(Paths.get(rutaArchivo))) {
                Files.createDirectories(Paths.get(rutaArchivo));
            }


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo + "/promedios.txt"))) {
                for (Alumno alumno : alumnos.values()) {
                    writer.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre() + " " + alumno.getApellido());
                    writer.newLine();


                    for (Materia materia : alumno.getMaterias()) {
                        double promedioMateria = promedioServicioImp.calcularPromedio(materia.getNotas());
                        writer.write("Materia: " + materia.getNombre() + " - Promedio: " + promedioMateria);
                        writer.newLine();
                    }

   
                    double promedioGeneral = calcularPromedioGeneral(alumno);
                    writer.write("Promedio general: " + promedioGeneral);
                    writer.newLine();
                    writer.newLine(); 
                }
            	Utilidad.mostrarMensaje("Datos exportados correctamente.");
            } catch (IOException e) {
            	Utilidad.mostrarMensaje("Error al escribir en el archivo: " + e.getMessage());
            }
        } catch (IOException e) {
        	Utilidad.mostrarMensaje("Error al verificar o crear directorio: " + e.getMessage());
        }
    }

    private double calcularPromedioGeneral(Alumno alumno) {
        double total = 0;
        int count = 0;
        for (Materia materia : alumno.getMaterias()) {
            total += promedioServicioImp.calcularPromedio(materia.getNotas());
            count++;
        }
        return count > 0 ? total / count : 0;
    }
}
