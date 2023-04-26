package Bmoll;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int numCopias;
    private int numCopiasDisponibles;
    private static int contadorDeLibros = 0; // static para poder acceder sin crear un objeto Libro, para posteriormente
                                             // poder acceder al numero total de libros

    public Libro() {

    }

    public Libro(String isbn, String titulo, String autor, String editorial, int numCopias, int numCopiasDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.numCopias = numCopias;
        this.numCopiasDisponibles = this.numCopias; // le damos el valor de las copias
        contadorDeLibros++;
    }

    public Libro(Libro copiaLibro) {
        this.isbn = copiaLibro.isbn;
        this.titulo = copiaLibro.titulo;
        this.autor = copiaLibro.autor;
        this.editorial = copiaLibro.editorial;
        this.numCopias = copiaLibro.numCopias;
        this.numCopiasDisponibles = copiaLibro.numCopiasDisponibles;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        if (numCopias < 1) {
            numCopias = 1;
        } else {
            this.numCopias = numCopias;
        }

    }

    public int getNumCopiasDisponibles() {
        return numCopiasDisponibles;
    }

    public void setNumCopiasDisponibles(int numCopiasDisponibles) {
        this.numCopiasDisponibles = numCopiasDisponibles;

    }

    public static int getContadorDeLibros() {
        return contadorDeLibros;
    }

    public static void setContadorDeLibros(int contadorDeLibros) {
        Libro.contadorDeLibros = contadorDeLibros;
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
                + ", numCopias=" + numCopias + ", numCopiasDisponibles=" + numCopiasDisponibles + "]";
    }

    public static void añadirLibro(ArrayList<Libro> listaLibros) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ISBN: ");
        String ISBN = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Editorial: ");
        String editorial = sc.nextLine();
        System.out.print("Número de copias: ");
        int numCopias = sc.nextInt();
        System.out.print("Número de copias disponibles: ");
        int numCopiasDisponibles = sc.nextInt();

        Libro libro = new Libro(ISBN, titulo, autor, editorial, numCopias, numCopiasDisponibles);
        listaLibros.add(libro);
        System.out.println("Libro añadido correctamente.");
    }

    public static void eliminarLibro(ArrayList<Libro> listaLibros) {
        Libro libroEliminar = null; // le damos valor null de momento hasta que hagamos la comparación de los isbn.
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el ISBN del libro a eliminar: ");
        String isbn = sc.nextLine();

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getIsbn().equals(isbn)) {
                libroEliminar = listaLibros.get(i); // Aquí lo que se hará es que en el propio bucle, se irá buscando un
                                                    // isbn que coincida con el que ha introducido el usuario
                break; // para posteriormente eliminarlo.
            }
        }

        if (libroEliminar != null) {
            if (libroEliminar.getNumCopiasDisponibles() == libroEliminar.getNumCopias()) {
                listaLibros.remove(libroEliminar); // Aquí miramos si hay alguna reserva hecha, ya que si no coinciden
                                                   // numCopias con
                System.out.println("Libro eliminado correctamente."); // numCopiasDisponibles, significa que hay alguna
                                                                      // reserva.
            } else {
                System.out.println("no se puede eliminar, tiene alguna reserva hecha");
            }

        } else {
            System.out.println("No se ha podido encontrar un libro con ese isbn");
        }
        sc.close();
    }

    public static int buscarLibroISBN(ArrayList<Libro> listaLibros) {

        // de la misma manera que he usado el null, lo usaré para los condicionales para
        // buscar el libro por ISBN.

        int posicion = 0; // usaremos esta variable para darle el valor de i al encontrar el libro.
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el ISBN del libro a buscar: ");
        String isbn = sc.nextLine();

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getIsbn().equals(isbn)) {
                posicion = i;
                return posicion;

            }
        }
        return -1;

    }

    public static Libro buscarLibroTitulo(ArrayList<Libro> listaLibros) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el título que quieres buscar:");
        String expresionRegular = ".*" + sc.nextLine() + ".*"; // Agregar .* antes y después de la cadena buscada para
                                                               // buscarla en cualquier posición del título
        Pattern pattern = Pattern.compile(expresionRegular, Pattern.CASE_INSENSITIVE); // https://stackoverflow.com/questions/3436118/is-java-regex-case-insensitive
        for (int i = 0; i < listaLibros.size(); i++) {
            if (pattern.matcher(listaLibros.get(i).getTitulo()).matches()) {
                return listaLibros.get(i);
            }
        }
        return null;

    }

}
