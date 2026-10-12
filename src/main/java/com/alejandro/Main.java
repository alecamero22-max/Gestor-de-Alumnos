package com.alejandro;

import java.util.ArrayList;
import java.util.Scanner;

import com.alejandro.clases.Alumno;

public class Main {
    public static void main(String[] args) {

        ArrayList<Alumno> arrayAlumnos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int contador = 0;
        do {
            System.out.println("AÑADIR ALUMNOS: 1");
            System.out.println("Visualizar alumnos: 2");
            System.out.println("Modificar alumno: 3");
            System.out.println("Salir: 4");

            opcion = sc.nextInt();
            sc.nextLine();

            
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre del alumno");
                    String nombre = sc.nextLine();
                    arrayAlumnos.add(new Alumno(nombre));
                    contador++;
                    System.out.println("Alumnos creados");
                    break;

                case 2:
                    for (int i = 0; i < contador; i++) {
                        System.out.println(arrayAlumnos.get(i).toString());
                    }
                    break;

                case 3:
                    System.out.println("¿Qué alumno quieres modificar? (1, 2 o 3)");
                    int numeroAlumno = sc.nextInt();
                    sc.nextLine();

                    if (numeroAlumno >= 1 && numeroAlumno <= contador) {
                        System.out.println("Introduce el nuevo nombre");
                        String nuevoNombre = sc.nextLine();

                        arrayAlumnos.get(numeroAlumno - 1).setNombre(nuevoNombre);
                        System.out.println("Alumno modificado");
                    } else {
                        System.out.println("Número de alumno no válido");
                    }
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opcion != 4);

        sc.close();
    }
}
