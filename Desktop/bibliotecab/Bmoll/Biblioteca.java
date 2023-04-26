package Bmoll;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class Biblioteca {
    private String nombreBiblioteca;
    private ArrayList<Libro> listaLibrosBiblioteca;
    private ArrayList<Persona> listaPersonalBiblioteca;

    public Biblioteca() {

    }

    public Biblioteca(String nombreBiblioteca, ArrayList<Libro> listaLibrosBiblioteca,
            ArrayList<Persona> listaPersonalBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.listaLibrosBiblioteca = listaLibrosBiblioteca;
        this.listaPersonalBiblioteca = listaPersonalBiblioteca;
    }

    public Biblioteca(Biblioteca copiaBiblioteca) {
        this.nombreBiblioteca = copiaBiblioteca.nombreBiblioteca;
        this.listaLibrosBiblioteca = new ArrayList<>(copiaBiblioteca.listaLibrosBiblioteca);
        this.listaPersonalBiblioteca = new ArrayList<>(copiaBiblioteca.listaPersonalBiblioteca);
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        // Uso de expresiones regulares para que obligatoriamente la primera letra sea
        // Mayuscula.
        Pattern pattern = Pattern.compile("^[A-Z].*");
        Matcher matcher = pattern.matcher(nombreBiblioteca);
        if (matcher.matches()) {
            this.nombreBiblioteca = nombreBiblioteca;
        } else {
            throw new IllegalArgumentException(
                    "OBLIGATORIAMENTE, el nombre de la biblioteca ha de empezar en mayúsculas :)");
        }
    }

    public ArrayList<Libro> getListaLibrosBiblioteca() {
        return listaLibrosBiblioteca;
    }

    public void setListaLibrosBiblioteca(ArrayList<Libro> listaLibrosBiblioteca) {
        this.listaLibrosBiblioteca = listaLibrosBiblioteca;
    }

    public ArrayList<Persona> getListaPersonalBiblioteca() {
        return listaPersonalBiblioteca;
    }

    public void setListaPersonalBiblioteca(ArrayList<Persona> listaPersonalBiblioteca) {
        this.listaPersonalBiblioteca = listaPersonalBiblioteca;
    }

    @Override
    public String toString() {
        return "Biblioteca [nombreBiblioteca=" + nombreBiblioteca + ", listaLibrosBiblioteca=" + listaLibrosBiblioteca
                + ", listaPersonalBiblioteca=" + listaPersonalBiblioteca + "]";
    }

    // Métodos

    public void mostrarLibros() {
        System.out.println("Esta es la lista de los libros de la biblioteca: " + nombreBiblioteca);
        for (int i = 0; i < listaLibrosBiblioteca.size(); i++) {
            Libro libro = listaLibrosBiblioteca.get(i); // Creamos la variable de tipo libro para ir añadiendole el
                                                        // valor de i de listaLibrosBiblioteca
            System.out.println(libro.toString() + "  ");
        }
    }

    public void añadirBibliotecario(Persona bibliotecario) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce nombre bibliotecario");
        String nombre = sc.nextLine();
        System.out.println("Apellido: ");
        String apellido = sc.nextLine();
        System.out.println("DNI: ");
        String dni = sc.nextLine();
        System.out.println("contraseña: ");
        String contraseña = sc.nextLine();
        Persona newbibliotecario = new Persona(nombre, apellido, dni, contraseña);
        System.out.println(newbibliotecario.toString());
        listaPersonalBiblioteca.add(newbibliotecario);
    }

    public void eliminarBibliotecario(Persona bibliotecario) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un nombre para borrar: ");
        String nombre = sc.nextLine();
        Persona bibliotecarioParaEliminar = null;
        for (int i = 0; i < listaPersonalBiblioteca.size(); i++) {
            Persona bibliotecarioTemp = listaPersonalBiblioteca.get(i); // Si o Si. Necesito un objeto para recorrer la
                                                                        // listaPersonalBiblioteca
            if (bibliotecarioTemp.getNombrePersona().equals(nombre)) { // Si el getNombrePersona coincide con el nombre
                                                                       // que nos ha introducido el usuario,.
                                                                       // la variable bibliotecarioParaEliminar pasa a
                                                                       // tener el valor de blibliotecarioTemp , para el
                                                                       // proximo uso.
                bibliotecarioParaEliminar = bibliotecarioTemp;
                break;
            }

        }
        if (bibliotecarioParaEliminar != null) {
            listaPersonalBiblioteca.remove(bibliotecarioParaEliminar);
            System.out.println("El bibliotecario ha sido eliminado.");
        } else {
            System.out.println("No se encontró ningún bibliotecario con ese nombre.");
        }
    }

    // Estos dos métodos deberían estar en la clase persona, pero no he sabido como.
}
