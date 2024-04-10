/*import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.PriorityQueue;

public class MainTest {

    @Test
    void testLeerPacientes() {
        String filePath = "src/test/java/org/example/test_pacientes.txt";

        try {
            PriorityQueue<Paciente> pacientesQueue = Main.leerPacientes(filePath);

            // Comprobamos que la cola de pacientes no esté vacía
            assertFalse(pacientesQueue.isEmpty());

            // Verificamos el orden de los pacientes en la cola
            Paciente[] pacientesEsperados = {
                    new Paciente("Maria Ramirez", "apendicitis", 'A'),
                    new Paciente("Carmen Sarmientos", "dolores de parto", 'B'),
                    new Paciente("Juan Perez", "fractura de pierna", 'C'),
                    new Paciente("Lorenzo Toledo", "chikungunya", 'E')
            };

            int i = 0;
            while (!pacientesQueue.isEmpty()) {
                Paciente paciente = pacientesQueue.poll();
                assertEquals(pacientesEsperados[i].getNombre(), paciente.getNombre());
                assertEquals(pacientesEsperados[i].getSintoma(), paciente.getSintoma());
                assertEquals(pacientesEsperados[i].getCodigoEmergencia(), paciente.getCodigoEmergencia());
                i++;
            }
        } catch (IOException e) {
            fail("Error al leer el archivo: " + e.getMessage());
        }
    }
}
*/
