package Bmoll;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
    private String nombrePersona;
    private String apellidos;
    private String dni;
    private String contraseña;

    public Persona() {
    }

    public Persona(String nombrePersona, String apellidos, String dni, String contraseña) {
        this.nombrePersona = nombrePersona;
        this.apellidos = apellidos;
        this.dni = dni;
        this.contraseña = contraseña;
    }

    public Persona(Persona copiaPersona) {
        this.nombrePersona = copiaPersona.getNombrePersona();
        this.apellidos = copiaPersona.getApellidos();
        this.dni = copiaPersona.getDni();
        this.contraseña = copiaPersona.getContraseña();
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return "Persona [nombrePersona=" + nombrePersona + ", apellidos=" + apellidos + ", dni=" + dni + ", contraseña="
                + contraseña + "]";
    }

    public void setContraseña(String contraseña) {

        if (contraseña.matches(".{8,}")) { // Esta es otra manera de usar la expresion regular, algo mas sencilla
                                           // En verdad, la que uso en la clase biblioteca no haría falta, ya que el
                                           // matcher y pattern
            this.contraseña = contraseña; // se podrían usar si se va a reciclar en algun momento la expresion regular.
                                          // También se podría usar un simple if (si length >= 8)
        } else {
            System.out.println("Por favor, la contraseña ha de tener al menos 8 dígitos. :)");

        }
    }

}
