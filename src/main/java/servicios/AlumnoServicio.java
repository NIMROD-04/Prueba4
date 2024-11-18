package servicios;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos;

    // Constructor
    public AlumnoServicio() {
        this.listaAlumnos = new HashMap<>();
    }

    // Método para crear un alumno
    public void crearAlumno(String rut, String nombre, String apellido, String direccion) {
        if (listaAlumnos.containsKey(rut)) {
            System.out.println("El alumno con RUT " + rut + " ya existe.");
        } else {
            Alumno nuevoAlumno = new Alumno(rut, nombre, apellido, direccion);
            listaAlumnos.put(rut, nuevoAlumno);
        }
    }

    // Método para agregar una materia a un alumno
    public void agregarMateria(String rutAlumno, int opcionMateria) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno == null) {
            System.out.println("El alumno con RUT " + rutAlumno + " no existe.");
            return;
        }

        MateriaEnum materiaEnum = MateriaEnum.values()[opcionMateria - 1];
        Materia materia = new Materia(materiaEnum);
        alumno.agregarMateria(materia);
    }

    // Método para agregar una nota a una materia de un alumno
    public void agregarNota(String rutAlumno, int indiceMateria, double nota) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno == null) {
            System.out.println("El alumno con RUT " + rutAlumno + " no existe.");
            return;
        }

        List<Materia> materias = alumno.getMaterias();
        if (indiceMateria <= 0 || indiceMateria > materias.size()) {
            System.out.println("Índice de materia inválido.");
            return;
        }

        Materia materia = materias.get(indiceMateria - 1);
        materia.agregarNota(nota);
    }

    // Método para listar materias de un alumno
    public List<Materia> materiasPorAlumno(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno == null) {
            System.out.println("El alumno con RUT " + rutAlumno + " no existe.");
            return new ArrayList<>();
        }
        return alumno.getMaterias();
    }

    // Método para listar todos los alumnos
    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }
}
