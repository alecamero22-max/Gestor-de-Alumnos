package com.alejandro;

import java.util.Scanner;

import com.alejandro.clases.Alumno;

public class Main {
    public static void main(String[] args) {
        Alumno a1 = new Alumno();
        Alumno a2 = new Alumno();
        Alumno a3 = new Alumno();
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

            if (opcion == 1) {
                if (contador>=3){
                    System.err.println("Ya están todos los alumnos escritos");

                }
                System.out.println("Introduce el nombre del alumno");
                String nombre = sc.nextLine();
                if (contador==0){
                    a1.setNombre(nombre);
                }else if(contador==1){
                    a2.setNombre(nombre);
                }else{
                    a3.setNombre(nombre);
                }
                contador++;
                System.out.println("Alumnos creados");
            } else if (opcion == 2) {
                System.out.println(a1.toString());
                System.out.println(a2.toString());
                System.out.println(a3.toString());

            } else if (opcion == 3) {
                System.out.println("¿Qué alumno quieres modificar? (1, 2 o 3)");
                int numeroAlumno = sc.nextInt();
                sc.nextLine();

                if (numeroAlumno >= 1 && numeroAlumno <= 3) {
                    System.out.println("Introduce el nuevo nombre");
                    String nuevoNombre = sc.nextLine();

                    if (numeroAlumno == 1) {
                        a1.setNombre(nuevoNombre);
                    } else if (numeroAlumno == 2) {
                        a2.setNombre(nuevoNombre);
                    } else {
                        a3.setNombre(nuevoNombre);
                    }
                    System.out.println("Alumno modificado");
                } else {
                    System.out.println("Número de alumno no válido");
                }
            }

        } while (opcion != 4);

        sc.close();
    }
}
