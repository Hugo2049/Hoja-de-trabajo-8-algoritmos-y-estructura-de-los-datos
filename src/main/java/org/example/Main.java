package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Clase principal que lee un archivo de pacientes, los organiza en un montículo y muestra el orden de atención.
 */
public class Main {

    /**
     * Método principal que inicia el programa.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/Pacientes.txt";

        try {
            Vector<Paciente> pacientes = leerPacientes(filePath);

            if (pacientes.isEmpty()) {
                System.out.println("No se encontraron pacientes en el archivo.");
                return;
            }

            VectorHeap<Paciente> heap = new VectorHeap<>(pacientes);

            System.out.println("Orden de atención de los pacientes:");
            while (!heap.data.isEmpty()) {
                Paciente paciente = heap.remove();
                System.out.println(paciente.getNombre() + ", " + paciente.getSintoma() + ", " + paciente.getCodigoEmergencia());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee los datos de los pacientes desde un archivo y los devuelve en un vector.
     * @param filePath La ruta del archivo que contiene los datos de los pacientes.
     * @return Un vector de pacientes leídos desde el archivo.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */
    public static Vector<Paciente> leerPacientes(String filePath) throws IOException {
        Vector<Paciente> pacientes = new Vector<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String nombre = parts[0].trim();
                String sintoma = parts[1].trim();
                char codigoEmergencia = parts[2].trim().charAt(0);
                pacientes.add(new Paciente(nombre, sintoma, codigoEmergencia));
            } else {
                System.out.println("Formato de línea incorrecto: " + line);
            }
        }

        reader.close();
        return pacientes;
    }
}
