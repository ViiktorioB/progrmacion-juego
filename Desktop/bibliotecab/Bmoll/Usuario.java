
package Bmoll;


import java.util.*;
import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String nif;
    private String contraseña;

    public Usuario(String nombre, String apellidos, String nif, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.contraseña = contraseña;

    }

    public Usuario(Usuario usuario) {
        this.nombre = usuario.getNombre();
        this.apellidos = usuario.getApellidos();
        this.nif = usuario.getNif();
        this.contraseña = usuario.getContraseña();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        if (contraseña.matches(".{8,}")) {
            this.contraseña = contraseña;
        } else {
            System.out.println("La contraseña debe tener al menos 8 caracteres.");
        }
    }

}
