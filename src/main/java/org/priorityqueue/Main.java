package org.priorityqueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/pacientes.txt";

        try {
            PriorityQueue<Paciente> pacientesQueue = leerPacientes(filePath);

            if (pacientesQueue.isEmpty()) {
                System.out.println("No se encontraron pacientes en el archivo.");
                return;
            }

            System.out.println("Orden de atención de los pacientes:");
            while (!pacientesQueue.isEmpty()) {
                Paciente paciente = pacientesQueue.poll();
                System.out.println(paciente.getNombre() + ", " + paciente.getSintoma() + ", " + paciente.getCodigoEmergencia());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static PriorityQueue<Paciente> leerPacientes(String filePath) throws IOException {
        PriorityQueue<Paciente> pacientesQueue = new PriorityQueue<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String nombre = parts[0].trim();
                String sintoma = parts[1].trim();
                char codigoEmergencia = parts[2].trim().charAt(0);
                pacientesQueue.add(new Paciente(nombre, sintoma, codigoEmergencia));
            } else {
                System.out.println("Formato de línea incorrecto: " + line);
            }
        }

        reader.close();
        return pacientesQueue;
    }
}

