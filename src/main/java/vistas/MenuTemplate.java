package vistas;

import java.util.Scanner;

public class MenuTemplate {
    private Scanner scanner = new Scanner(System.in);

    public void exportarDatos() {
        // Implementación vacía
    }

    public void crearAlumno() {
        // Implementación vacía
    }

    public void agregarMateria() {
        // Implementación vacía
    }

    public void agregarNotaPasoUno() {
        // Implementación vacía
    }

    public void listarAlumnos() {
        // Implementación vacía
    }

    public void terminarPrograma() {
        // Implementación vacía
    }

    public final void iniciarMenu() {
        int opcion;
        do {
            System.out.println("--- Menú Principal ---");
            System.out.println("1. Crear Alumno");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. Exportar Datos");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> crearAlumno();
                case 2 -> listarAlumnos();
                case 3 -> agregarMateria();
                case 4 -> agregarNotaPasoUno();
                case 5 -> terminarPrograma();
                case 6 -> exportarDatos();
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}
