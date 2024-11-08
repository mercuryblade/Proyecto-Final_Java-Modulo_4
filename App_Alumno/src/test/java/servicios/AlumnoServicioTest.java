package servicios;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.Alumno;
import modelo.Materia;
import modelo.MateriaEnum;

/**
 * @Params se generan varias pruebas para probar el funcionamiento de los metodos que incluira el programa
 */
public class AlumnoServicioTest {

    private AlumnoServicio alumnoServicio;
    private AlumnoServicio alumnoServicioMock;
    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;

    @BeforeEach
    public void setup() {
        alumnoServicio = new AlumnoServicio(); 
        alumnoServicioMock = mock(AlumnoServicio.class);
        matematicas = new Materia();
        matematicas.setNombre(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia();
        matematicas.setNombre(MateriaEnum.LENGUAJE);
        mapu = new Alumno("17242630-1", "Felipe", "Villegas", "Rancagua 123");
       
    }

    @Test
    public void crearAlumnoTest() {

        alumnoServicio.crearAlumno(mapu);

        assertTrue(alumnoServicio.listarAlumnos().containsKey(mapu.getRut()), "El alumno debe estar en la lista.");
    }

    @Test
    public void agregarMateriaTest() {

        alumnoServicio.crearAlumno(mapu); 
        alumnoServicio.agregarMateria(mapu.getRut(), matematicas);
        assertTrue(mapu.getMaterias().contains(matematicas), "El alumno debe tener la materia Matemáticas.");
    }

    @Test
    public void materiasPorAlumnosTest() {
        when(alumnoServicioMock.materiasPorAlumno("12345")).thenReturn(List.of(matematicas, lenguaje));
        List<Materia> materias = alumnoServicioMock.materiasPorAlumno("12345");
        assertTrue(materias.contains(matematicas), "La materia Matemáticas debe estar en la lista.");
        assertTrue(materias.contains(lenguaje), "La materia Lenguaje debe estar en la lista.");
    }
    @Test
    public void listarAlumnosTest() {

        alumnoServicio.crearAlumno(mapu);
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertFalse(alumnos.isEmpty(), "La lista de alumnos no debe estar vacía.");
        assertTrue(alumnos.containsKey(mapu.getRut()), "El alumno debe estar en la lista.");
    }
}
