package servicios;

import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumno = new HashMap<>();

    public void crearAlumno(Alumno alumno) {
        listaAlumno.put(alumno.getRut(), alumno);
    }

    public void agregarMateria(String rutAlumno, Materia currentMateria) {
        Alumno alumno = listaAlumno.get(rutAlumno);
        if (alumno != null) {
            alumno.getMaterias().add(currentMateria);
        }
    }

    public List<Materia> materiasPorAlumno(String rutAlumno) {
        Alumno alumno = listaAlumno.get(rutAlumno);
        return (alumno != null) ? alumno.getMaterias() : null;
    }

    public Map<String, Alumno> listarAlumnos() {
        return listaAlumno;
    }
    public void agregarNota(String rutAlumno, MateriaEnum materia, double nota) {
        Alumno alumno = listaAlumno.get(rutAlumno);
        if (alumno != null) {
        
            for (Materia m : alumno.getMaterias()) {
                if (m.getNombre() == materia) {
                    m.getNotas().add(nota); 
                    break;
                }
            }
        }
    }
}
