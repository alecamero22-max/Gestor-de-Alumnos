package com.alejandro.modelo;

public class Alumno extends Usuario {
    private String idExpediente;
    private int curso;
    private double notaMedia;

    public Alumno(int id, String nombre, int edad, String idExpediente, int curso, double notaMedia) {
        super(id, nombre, edad);
        this.idExpediente = idExpediente;
        this.curso = curso;
        this.notaMedia = notaMedia;
    }

    public String getIdExpediente() {
        return idExpediente;
    }

    public int getCurso() {
        return curso;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return super.equals(obj) && idExpediente.equals(alumno.idExpediente);
    }

    @Override
    public int hashCode() {
        int superHash = super.hashCode();
        return 31 * superHash + idExpediente.hashCode();
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idExpediente='" + idExpediente + '\'' +
                ", curso=" + curso +
                ", notaMedia=" + notaMedia +
                '}';
    }
}