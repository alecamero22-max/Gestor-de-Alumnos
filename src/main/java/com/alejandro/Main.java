package com.alejandro;

import java.util.Scanner;

import com.alejandro.clases.Alumno;

public class Main {
    public static void main(String[] args) {

        Alumno[] arrayAlumnos = new Alumno[3];
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int contador = 0;
        boolean sigue = false;
        do {
            System.out.println("AÑADIR ALUMNOS: 1");
            System.out.println("Visualizar alumnos: 2");
            System.out.println("Modificar alumno: 3");
            System.out.println("Salir: 4");

            opcion = sc.nextInt();
            sc.nextLine();

            /** Adaptar el añadir alumnos usando arrays */
            if (opcion == 1) {
                if (contador >= 3) {
                    System.err.println("Ya están todos los alumnos escritos");
                } else {
                    System.out.println("Introduce el nombre del alumno");
                    String nombre = sc.nextLine();
                    arrayAlumnos[contador] = new Alumno(nombre);
                    contador++;
                    System.out.println("Alumnos creados");
                }

                /* Visualizar alumnos con un bucle recorriendo el array */
            } else if (opcion == 2) {
                for (int i = 0; i < contador; i++) {
                    System.out.println(arrayAlumnos[i].toString());
                }

                /** Modificar con un bucle hasta encontrar el alumno */
            } else if (opcion == 3) {
                System.out.println("¿Qué alumno quieres modificar? (1, 2 o 3)");
                int numeroAlumno = sc.nextInt();
                sc.nextLine();

                if (numeroAlumno >= 1 && numeroAlumno <= contador) {
                    System.out.println("Introduce el nuevo nombre");
                    String nuevoNombre = sc.nextLine();

                    arrayAlumnos[numeroAlumno - 1].setNombre(nuevoNombre);
                    System.out.println("Alumno modificado");
                } else {
                    System.out.println("Número de alumno no válido");
                }
            }

        } while (opcion != 4);

        sc.close();
    }
}
