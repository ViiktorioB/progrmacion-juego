package hospital;
import java.time.LocalDate;

public class Visita {
   
    private String codVisita;
    private LocalDate fechaVisita;
    private Paciente paciente;
    private Medico medico;
    private int tipoVisita;
    private String descripcion;
    private String tratamiento;
    private double precio;

    public static final int CONSULTA = 0;
    public static final int REVISION = 1;
    public static final int RECETAS = 2;
    public static final int URGENCIAS = 3;
    public static final int PRECIO_MINIMO = 50;

    public static int numRevisiones = 0;
    public static int numRecetas = 0;
    public static int numConsultas = 0;
    public static int numUrgencias = 0;
    
    public Visita(String codVisita, LocalDate fechaVisita, Paciente paciente, Medico medico, int tipoVisita,
                    String descripcion, String tratamiento, double precio) {
        this.codVisita = codVisita;
        this.fechaVisita = fechaVisita;
        this.paciente = paciente;
        this.medico = medico;
        this.tipoVisita = tipoVisita;
        this.descripcion = descripcion;
        this.tratamiento = tratamiento;
        this.precio = precio;
    }


    @Override
    public String toString(){
        return "Visita: " + codVisita
                + " Paciente: " +"("+ paciente.getCodigo() + paciente.getNombre() +")"
                + " Tipo de visita: " + tipoVisita 
                +  " Fecha " + fechaVisita
                + " Medico: " + medico.getNombre()
                + "Precio" + precio;
               
    }

    public static int devuelveNumVisitas(String tipo){
        switch(tipo){
            case "CONSULTA":
            return numConsultas;

            case "REVISION":
            return numRevisiones;

            case "RECETAS":
            return numRecetas;

            case "URGENCIAS":
            return numUrgencias;

            default:
            return 0;
        }
    }

    public void  incrementarVisita(String tipoVisita){
       switch(tipoVisita){
        case "CONSULTA":
            numConsultas++;
            break;

            case "REVISION":
            numRevisiones++;
            break;

            case "RECETAS":
            numRecetas++;
            break;

            case "URGENCIAS":
            numUrgencias++;
            break;

            default:
            System.out.println("no valido");
           
        }

       }

        public void reinicializarVisita(){
            numConsultas=0;
            numRevisiones = 0;
            numRecetas = 0;
            numUrgencias = 0;
        }

}



