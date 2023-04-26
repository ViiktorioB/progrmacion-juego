package Bmoll;

import java.util.ArrayList;
import java.util.Scanner;
// HAY QUE ARREGLAR TODOS LOS TOSTRING. // HAY QUE ARREGLAR TODOS LOS TOSTRING. // HAY QUE ARREGLAR TODOS LOS TOSTRING. // HAY QUE ARREGLAR TODOS LOS TOSTRING.

public class Menu {

    public static void main(String[] args) {
        Biblioteca borjaMoll = new Biblioteca("BorjaMoll", new ArrayList<Libro>(), new ArrayList<Persona>());
        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> listaLibros = new ArrayList<Libro>();

        int opcion = 0;
        do {
            System.out.println("Bienvenido a la biblioteca " + borjaMoll.getNombreBiblioteca());
            System.out.println("Seleccione una opción:");
            System.out.println("1. Añadir un libro");
            System.out.println("2. Eliminar un libro");
            System.out.println("3. Buscar un libro por ISBN");
            System.out.println("4. Buscar un libro por título");
            System.out.println("5.Añadir Bibliotecario");
            System.out.println("5. Salir");
            int opcion1 = sc.nextInt();

            switch (opcion1) {
                case 1:
                    Libro.añadirLibro(listaLibros);
                    System.out.println("El libro ha sido añadido a la biblioteca.");
                    break;
                case 2:
                    Libro.eliminarLibro(listaLibros);
                    System.out.println("El libro ha sido eliminado de la biblioteca.");
                    break;
                case 3:
                    int posicion = Libro.buscarLibroISBN(listaLibros);
                    if (posicion != -1) {
                        System.out.println("El libro se encuentra en la posición " + posicion + " de la lista.");
                    } else {
                        System.out.println("El libro no se encuentra en la lista.");
                    }
                    break;

                case 4:
                    Libro libroEncontrado = Libro.buscarLibroTitulo(listaLibros);
                    if (libroEncontrado != null) {
                        System.out.println("El libro encontrado es: " + libroEncontrado.toString());
                    } else {
                        System.out.println("No se encontró ningún libro con ese título.");
                    }
                    break;
                case 5:
                    Persona b1 = new Persona();
                    borjaMoll.añadirBibliotecario(b1);

                    break;
                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println();
        } while (opcion != 8);
    }
}
// System.out.println("Gracias por utilizar la biblioteca " +
// borjaMoll.getNombreBiblioteca());