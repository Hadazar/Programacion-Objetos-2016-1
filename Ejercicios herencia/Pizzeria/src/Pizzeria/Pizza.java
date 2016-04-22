

package pizzeria;

/**
 * @HéctorDaza
 * @AndrésIriarte
 */
public abstract class Pizza {

    //Caracteristica de una pizza estandar de La Pizzeria
    public String pasos;
    public String masa;
    public String salsa;
    public String tipoCorte;
    public String empaque;
    public double tiempoOrneado;
    public String imagen;
    public String[] ingredientes;

    //Constructor de Pizza
    public Pizza(String masa, String salsa, String tipoCorte, String empaque, String imagen, double tiempoOrneado, String[] ingredientes, String pasos) {
        this.masa = masa;
        this.salsa = salsa;
        this.tipoCorte = tipoCorte;
        this.tiempoOrneado = tiempoOrneado;
        this.empaque = empaque;
        this.ingredientes = ingredientes;
        //Añade la ruta de las imagenes y añade el valor de la pizza correspondiente
        this.imagen = "src/pizzeria/image/"+imagen+".jpg";
        this.pasos = pasos;
    }

    //Metodos abstractos que toda pizza debe tener
    public abstract void preparar();

    public abstract void ornear();

    public abstract void cortar();

    public abstract void empacar();
}
