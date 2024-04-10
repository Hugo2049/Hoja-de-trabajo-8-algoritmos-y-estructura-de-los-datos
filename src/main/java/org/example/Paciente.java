package org.example;

/**
 * Clase que representa a un paciente en un sistema de atención médica de emergencia.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre; // Nombre del paciente
    private String sintoma; // Síntoma del paciente
    private char codigoEmergencia; // Código de emergencia del paciente

    /**
     * Constructor de la clase Paciente.
     * @param nombre El nombre del paciente.
     * @param sintoma El síntoma que presenta el paciente.
     * @param codigoEmergencia El código de emergencia asignado al paciente.
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Obtiene el nombre del paciente.
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el síntoma del paciente.
     * @return El síntoma del paciente.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene el código de emergencia del paciente.
     * @return El código de emergencia del paciente.
     */
    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    /**
     * Compara este paciente con otro paciente basado en el código de emergencia.
     * @param otro El otro paciente con el que se va a comparar.
     * @return Un valor negativo si este paciente tiene un código de emergencia menor que el otro,
     *         cero si ambos pacientes tienen el mismo código de emergencia,
     *         o un valor positivo si este paciente tiene un código de emergencia mayor que el otro.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }
}
