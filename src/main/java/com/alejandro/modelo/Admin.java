package com.alejandro.modelo;

public class Admin extends Usuario {
    private String rolPermisos;

    public Admin(int id, String nombre, int edad, String rolPermisos) {
        super(id, nombre, edad);
        this.rolPermisos = rolPermisos;
    }

    public String getRolPermisos() {
        return rolPermisos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Admin admin = (Admin) obj;
        return super.equals(obj) && rolPermisos.equals(admin.rolPermisos);
    }

    @Override
    public int hashCode() {
        int superHash = super.hashCode();
        return 31 * superHash + rolPermisos.hashCode();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "rolPermisos='" + rolPermisos + '\'' +
                '}';
    }
}