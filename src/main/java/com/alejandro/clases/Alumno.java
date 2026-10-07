package com.alejandro.clases;

public class Alumno {
	private int nota;
	private String nombre;
	private int edad;

    public void setEdad(int edad) {
        this.edad = edad;
    }

	public int getEdad() {
		return edad;
	}
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alumno{");
        sb.append("nota=").append(nota);
        sb.append(", nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }

	
	
}
