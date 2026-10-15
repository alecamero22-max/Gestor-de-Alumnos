package com.alejandro;

import com.alejandro.controller.UsuarioController;
import com.alejandro.modelo.Alumno;
import com.alejandro.modelo.Admin;
import com.alejandro.modelo.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioController controller = new UsuarioController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== GESTOR DE ALUMNOS ===");
        System.out.println("Sistema iniciado con administrador y alumnos de ejemplo.\n");

        boolean activo = true;
        while (activo) {
            printlnMenu();

            int opcion = leerOpcion(scanner);

            if (opcion == -1) {
                System.out.println("Saliendo del programa.");
                activo = false;
            } else {
                procesarOpcion(opcion, controller, scanner);
            }
        }

        controller.cerrar();
        scanner.close();
    }

    private static void printlnMenu() {
        System.out.println("\nGESTOR DE ALUMNOS");
        System.out.println("1. Listar todos los usuarios");
        System.out.println("2. Listar alumnos");
        System.out.println("3. Buscar usuario por ID");
        System.out.println("4. Registrar alumno");
        System.out.println("5. Mostrar información del administrador");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void procesarOpcion(int opcion, UsuarioController controller, Scanner scanner) {
        switch (opcion) {
            case 1:
                System.out.println("\n" + controller.listarUsuarios());
                break;
            case 2:
                System.out.println("\n" + controller.listarAlumnos());
                break;
            case 3:
                System.out.print("\nIntroduzca el ID del usuario a buscar: ");
                int idBusqueda = leerEntero(scanner);
                scanner.nextLine();
                System.out.println(controller.buscarUsuario(idBusqueda));
                break;
            case 4:
                registrarAlumno(controller, scanner);
                break;
            case 5:
                Admin admin = controller.obtenerAdmin();
                if (admin != null) {
                    System.out.println("\n" + admin.toString());
                } else {
                    System.out.println("\nNo se encontró el administrador.");
                }
                break;
            case 6:
                System.out.println("Saliendo del programa. Goodbye!");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione entre 1 y 6.");
        }
    }

    private static int leerOpcion(Scanner scanner) {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                return opcion;
            } else {
                scanner.nextLine();
                printlnMenu();
                System.out.print("Seleccione una opción: ");
            }
        }
        return -1;
    }

    private static int leerEntero(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.print("Introduzca el ID: ");
            }
        }
    }

    private static void registrarAlumno(UsuarioController controller, Scanner scanner) {
        System.out.print("Introduzca el ID del alumno: ");
        int id = leerEntero(scanner);

        System.out.print("Introduzca el nombre del alumno: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduzca la edad: ");
        int edad = leerEntero(scanner);

        System.out.print("Introduzca el ID de expediente: ");
        String idExpediente = scanner.nextLine();

        System.out.print("Introduzca el curso: ");
        int curso = leerEntero(scanner);

        System.out.print("Introduzca la nota media: ");
        double notaMedia = leerDouble(scanner);

        Alumno nuevoAlumno = new Alumno(id, nombre, edad, idExpediente, curso, notaMedia);

        System.out.print("¿Quién realiza la operación? (escriba 'admin' para usar el administrador actual): ");
        String quien = scanner.nextLine();

        Usuario usuarioQueSolicita;
        if ("admin".equalsIgnoreCase(quien)) {
            usuarioQueSolicita = controller.obtenerAdmin();
        } else {
            System.out.print("Introduzca el ID del usuario que solicita: ");
            int idUsuario = leerEntero(scanner);
            usuarioQueSolicita = controller.buscarPorId(idUsuario);
            if (usuarioQueSolicita == null) {
                System.out.println("Usuario con ID " + idUsuario + " no encontrado.");
                return;
            }
        }

        String resultado = controller.registrarAlumno(nuevoAlumno, usuarioQueSolicita);
        System.out.println("\n" + resultado);
    }

    private static double leerDouble(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                scanner.nextLine();
                System.out.print("Introduzca la nota media: ");
            }
        }
    }
}