# Hoja-de-trabajo-8-algoritmos-y-estructura-de-los-datos
**Creador:** Hugo Ernesto Barillas Villagrán 23306

**Sistema de Colas con Prioridad para Atender Pacientes en Emergencias Hospitalarias**

La hoja de trabajo 8 que simula un programa para atender pacientes en la sección de Emergencias de un hospital. El sistema está diseñado para gestionar la prioridad de atención de los pacientes según la gravedad de su condición médica, utilizando una cola con prioridad implementada con una estructura de montículo.

**Instrucciones de Uso**

Estructura de la Ficha del Paciente: Al llegar un paciente a la sección de Emergencias, se llena una ficha de ingreso con la siguiente información, en este caso se da un .txt con los datos ya hechos:

Nombre del paciente

**Descripción del síntoma**

Código de emergencia (A-E, donde A es la prioridad más alta y E la más baja)

Archivo de Entrada: Los datos de los pacientes se proporcionan en un archivo de texto llamado pacientes.txt, donde cada línea representa la ficha de un paciente con los campos separados por comas.

**Funcionamiento del Sistema:**

Los pacientes se ingresan en una cola con prioridad basada en sus códigos de emergencia.

Cuando se solicita el siguiente paciente para atención, se retira de la cola el paciente con la prioridad más alta y se muestra su nombre, síntoma y código de emergencia.

**Estructura de los Archivos**

**Paciente.java**: Clase que representa la ficha de un paciente, implementa la interfaz Comparable para comparar pacientes según su código de emergencia.

**VectorHeap.java**: Implementación de una cola con prioridad utilizando un montículo binario basado en un Vector.

**Main.java**: Clase principal que lee el archivo de pacientes, los ingresa en la cola con prioridad y muestra el orden de atención.

**Ejecución del Programa**

Para ejecutar el programa, simplemente compila y ejecuta la clase Main.java. Asegúrate de tener el archivo de pacientes (pacientes.txt) en la ubicación especificada en el código, yo la deje en la carpeta de maven, hay dos carpetas, una de example que venia con la que cree el maven, ahí hice la primera implementación del programa y la segunda priority, en la cual es la versión con el priority queue.

**Pruebas Unitarias**

Se incluyen pruebas unitarias para los métodos de inserción y eliminación de elementos en la cola con prioridad.

Versión Utilizando Java Collection Framework

Además de la implementación propia de la cola con prioridad, se proporciona una versión alternativa del programa utilizando la clase PriorityQueue del Java Collection Framework.

**NOTA**: deje el maintest como comentario porque no recuerdo que le modifique pero si no estoy mal, no lee el archivo paciente, entonces para que no afecte lo deje como comentario.