
package com.miempresa.tienda;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemaAtencionTienda {

    public static void main(String[] args) {
        // Crear la cola para almacenar los nombres de los clientes.
        Queue<String> filaClientes = new LinkedList<>();

        // Crear un objeto Scanner para leer la entrada del usuario desde la consola.
        Scanner scanner = new Scanner(System.in);

        // Mostrar un mensaje de bienvenida.
        System.out.println("Bienvenido al Sistema de Atención de la Tienda");
        System.out.println("Comandos disponibles: LLEGAR [nombre], ATENDER, MOSTRAR, SALIR");

        // Bucle principal del programa.  Se ejecuta hasta que el usuario ingrese "SALIR".
        while (true) {
            System.out.print("> "); // Prompt para indicar que el programa espera un comando.
            String comandoCompleto = scanner.nextLine(); // Leer una línea completa de entrada.
            String[] partes = comandoCompleto.split(" ", 2); // Dividir la entrada en partes, separadas por espacios.
            String comando = partes[0].toUpperCase(); // Convertir el comando a mayúsculas para hacerlo insensible a mayúsculas/minúsculas.

            // Usar una estructura switch para procesar los diferentes comandos.
            switch (comando) {
                case "LLEGAR":
                    // Verificar que se haya proporcionado un nombre de cliente.
                    if (partes.length > 1) {
                        String nombreCliente = partes[1];
                         // Verificar si el nombre del cliente no está vacío ni contiene solo espacios.
                        if (nombreCliente.trim().isEmpty()) {
                            System.out.println("Error: El nombre del cliente no puede estar vacío.");
                        } else {
                            filaClientes.offer(nombreCliente); // Agregar el cliente a la cola.
                            System.out.println("Cliente " + nombreCliente + " agregado a la fila.");
                        }
                    } else {
                        System.out.println("Error: Debe especificar el nombre del cliente.  Uso: LLEGAR [nombre]");
                    }
                    break;

                case "ATENDER":
                    // Verificar si hay clientes en la fila antes de intentar atender.
                    if (!filaClientes.isEmpty()) {
                        String clienteAtendido = filaClientes.poll(); // Obtener y eliminar el primer cliente de la cola.
                        System.out.println("Atendiendo a: " + clienteAtendido);
                    } else {
                        System.out.println("No hay clientes en la fila.");
                    }
                    break;

                case "MOSTRAR":
                    // Mostrar el estado actual de la fila.
                    if (!filaClientes.isEmpty()) {
                        System.out.println("Fila actual: " + String.join(", ", filaClientes));
                    } else {
                        System.out.println("La fila está vacía.");
                    }
                    break;

                case "SALIR":
                    // Salir del programa.
                    System.out.println("Saliendo del sistema...");
                    scanner.close(); // Cerrar el Scanner para liberar recursos.
                    return; // Terminar el método main, lo que finaliza el programa.

                default:
                    // Manejar comandos desconocidos.
                    System.out.println("Comando inválido.  Comandos disponibles: LLEGAR [nombre], ATENDER, MOSTRAR, SALIR");
            }
        }
    }
}