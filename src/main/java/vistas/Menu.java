package vistas;

import servicios.AlumnoServicio;
import servicios.ArchivoServicio;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();

    @Override
    public void exportarDatos() {
        System.out.println("--- Exportar Datos ---");
        System.out.print("Ingresa la ruta donde deseas exportar los datos: ");
        String ruta = new java.util.Scanner(System.in).nextLine();
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
        System.out.println("Datos exportados correctamente.");
    }

    @Override
    public void crearAlumno() {
        System.out.println("--- Crear Alumno ---");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingresa RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = scanner.nextLine();

        alumnoServicio.crearAlumno(rut, nombre, apellido, direccion);
        System.out.println("--- ¡Alumno agregado! ---");
    }

    @Override
    public void agregarMateria() {
        System.out.println("--- Agregar Materia ---");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingresa el RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.println("1. MATEMATICAS\n2. LENGUAJE\n3. CIENCIA\n4. HISTORIA");
        System.out.print("Selecciona una materia: ");
        int opcionMateria = scanner.nextInt();
        alumnoServicio.agregarMateria(rut, opcionMateria);
        System.out.println("--- ¡Materia agregada! ---");
    }

    @Override
    public void agregarNotaPasoUno() {
        System.out.println("--- Agregar Nota ---");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingresa el RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.println("Alumno tiene las siguientes materias: ");
        alumnoServicio.materiasPorAlumno(rut).forEach(System.out::println);

        System.out.print("Selecciona una materia (número): ");
        int opcionMateria = scanner.nextInt();
        System.out.print("Ingresa la nota: ");
        double nota = scanner.nextDouble();

        alumnoServicio.agregarNota(rut, opcionMateria, nota);
        System.out.println("--- ¡Nota agregada! ---");
    }

    @Override
    public void listarAlumnos() {
        System.out.println("--- Listar Alumnos ---");
        alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("RUT: " + rut);
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            System.out.println("Materias:");
            alumno.getMaterias().forEach(materia -> {
                System.out.println(" - " + materia.getNombre());
                System.out.println("   Notas: " + materia.getNotas());
            });
        });
    }

    @Override
    public void terminarPrograma() {
        System.out.println("--- Programa Finalizado ---");
        System.exit(0);
    }
}
