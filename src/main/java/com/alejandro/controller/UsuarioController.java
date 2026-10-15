package com.alejandro.controller;

import com.alejandro.modelo.Alumno;
import com.alejandro.modelo.Admin;
import com.alejandro.modelo.Usuario;
import com.alejandro.service.GestorService;

import java.util.List;
import java.util.Scanner;

public class UsuarioController {
    private final GestorService gestorService;
    private final Scanner scanner;

    public UsuarioController() {
        this.gestorService = new GestorService();
        this.scanner = new Scanner(System.in);
    }

    public String listarUsuarios() {
        List<Usuario> lista = gestorService.listarUsuarios();
        if (lista.isEmpty()) {
            return "No hay usuarios registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (Usuario u : lista) {
            sb.append(u).append("\n");
        }
        return sb.toString();
    }

    public String listarAlumnos() {
        List<Alumno> alumnos = gestorService.listarAlumnos();
        if (alumnos.isEmpty()) {
            return "No hay alumnos registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (Alumno a : alumnos) {
            sb.append(a).append("\n");
        }
        return sb.toString();
    }

    public String buscarUsuario(int id) {
        Usuario u = gestorService.buscarPorId(id);
        if (u == null) {
            return "Usuario con ID " + id + " no encontrado.";
        }
        return u.toString();
    }

    public Usuario buscarPorId(int id) {
        return gestorService.buscarPorId(id);
    }

    public String registrarAlumno(Alumno alumno, Usuario usuarioQueSolicita) {
        if (!gestorService.tienePermisoRegistro(usuarioQueSolicita)) {
            return "ACCION DENEGADA: Solo un administrador puede registrar alumnos.";
        }
        if (!gestorService.agregarAlumno(alumno)) {
            return "No se pudo registrar el alumno. Ya existe un usuario con el mismo ID.";
        }
        return "Alumno registrado exitosamente: " + alumno.getNombre();
    }

    public Admin obtenerAdmin() {
        for (Usuario u : gestorService.listarUsuarios()) {
            if (u instanceof Admin) {
                return (Admin) u;
            }
        }
        return null;
    }

    public void cerrar() {
        scanner.close();
    }
}