package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Main {
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

    private static Vector<Paciente> leerPacientes(String filePath) throws IOException {
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
