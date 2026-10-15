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
                    arrayAlumnos = crearAlumno(nombre, arrayAlumnos);
                    contador++;
                    break;

                case 2:
                    visualizarAlumnos(arrayAlumnos, contador);
                    break;

                case 3:
                    System.out.println("¿Qué alumno quieres modificar? (1, 2 o 3)");
                    int numeroAlumno = sc.nextInt();
                    sc.nextLine();

                    if (numeroAlumno >= 1 && numeroAlumno <= contador) {
                        System.out.println("Introduce el nuevo nombre");
                        String nuevoNombre = sc.nextLine();

                        arrayAlumnos = modificarAlumno(numeroAlumno, nuevoNombre, arrayAlumnos);
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

    public static ArrayList<Alumno> crearAlumno(String nombre, ArrayList<Alumno> alumnos) {
        Alumno nuevoAlumno = new Alumno(nombre);
        alumnos.add(nuevoAlumno);
        System.out.println("Alumnos creados");
        return alumnos;
    }

    public static void visualizarAlumnos(ArrayList<Alumno> alumnos, int contador) {
        for (int i = 0; i < contador; i++) {
            System.out.println(alumnos.get(i).toString());
        }
    }

    public static ArrayList<Alumno> modificarAlumno(int numeroAlumno, String nuevoNombre, ArrayList<Alumno> alumnos) {
        alumnos.get(numeroAlumno - 1).setNombre(nuevoNombre);
        System.out.println("Alumno modificado");
        return alumnos;
    }
}