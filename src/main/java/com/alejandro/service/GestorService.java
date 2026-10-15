package com.alejandro.service;

import com.alejandro.modelo.Alumno;
import com.alejandro.modelo.Admin;
import com.alejandro.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestorService {
    private final List<Usuario> usuarios;

    public GestorService() {
        this.usuarios = new ArrayList<>();
        Admin admin = new Admin(1, "Admin Principal", 35, "SUPER_ADMIN");
        usuarios.add(admin);

        usuarios.add(new Alumno(2, "Maria Garcia", 20, "EXP-2024-01", 2, 8.5));
        usuarios.add(new Alumno(3, "Juan Perez", 21, "EXP-2024-02", 3, 7.2));
        usuarios.add(new Alumno(4, "Laura Martin", 19, "EXP-2024-03", 1, 9.1));
    }

    public boolean agregarAlumno(Alumno alumno) {
        if (buscarPorId(alumno.getId()) != null) {
            return false;
        }
        return usuarios.add(alumno);
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u instanceof Alumno) {
                resultado.add((Alumno) u);
            }
        }
        return resultado;
    }

    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public boolean tienePermisoRegistro(Usuario usuario) {
        return usuario instanceof Admin;
    }
}