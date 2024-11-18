package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ArchivoServicio {

    public void exportarDatos(Map<String, Alumno> alumnos, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre() + "\n");
                for (Materia materia : alumno.getMaterias()) {
                    double promedio = calcularPromedio(materia.getNotas());
                    writer.write("  Materia: " + materia.getNombre() + " - Promedio: " + promedio + "\n");
                }
            }
            System.out.println("Datos exportados correctamente a: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar los datos: " + e.getMessage());
        }
    }

    private double calcularPromedio(List<Double> notas) {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (Double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}
