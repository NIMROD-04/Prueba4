package servicios;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AlumnoServicioTest {

    private AlumnoServicio alumnoServicio;

    @BeforeEach
    public void setUp() {
        alumnoServicio = new AlumnoServicio();
        alumnoServicio.crearAlumno("1.111.111-1", "Milton", "P.", "Casita 1");
    }

    @Test
    public void crearAlumnoTest() {
        assertEquals(1, alumnoServicio.listarAlumnos().size());
        assertNotNull(alumnoServicio.listarAlumnos().get("1.111.111-1"));
    }

    @Test
    public void agregarMateriaTest() {
        alumnoServicio.agregarMateria("1.111.111-1", 1);
        Alumno alumno = alumnoServicio.listarAlumnos().get("1.111.111-1");
        List<Materia> materias = alumno.getMaterias();

        assertEquals(1, materias.size());
        assertEquals(MateriaEnum.MATEMATICAS, materias.get(0).getNombre());
    }

    @Test
    public void materiasPorAlumnoTest() {
        alumnoServicio.agregarMateria("1.111.111-1", 1);
        List<Materia> materias = alumnoServicio.materiasPorAlumno("1.111.111-1");

        assertEquals(1, materias.size());
        assertEquals(MateriaEnum.MATEMATICAS, materias.get(0).getNombre());
    }
}
