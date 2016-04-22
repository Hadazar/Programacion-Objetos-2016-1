

package pizzeria;

/**
 * @HéctorDaza
 * @AndrésIriarte
 */
public class Peperoni extends Pizza {

    //Constructor de Peperoni
    public Peperoni(String masa, String salsa, String tipoCorte, String empaque, String imagen, double tiempoOrneado, String[] ingredientes, String pasos) {
        super(masa, salsa, tipoCorte, empaque, imagen, tiempoOrneado, ingredientes, pasos);
    }

    //Implementación de los metodos para Peperoni
    @Override
    public void preparar() {
        pasos += "\nLa pizza de Pepperoni se preparó y amasó para obtener masa de tipo " + masa;
        pasos += "\nAdicionando salsa " + salsa;

        for (int i = 0; i < ingredientes.length; i++) {
            pasos += "\nAdicionando " + ingredientes[i];
        }
        ornear();
    }

    @Override
    public void ornear() {
        pasos += "\nHorneada por " + tiempoOrneado + " minutos";
        cortar();
    }

    @Override
    public void cortar() {
        pasos += "\nCortada " + tipoCorte;
        empacar();
    }

    @Override
    public void empacar() {
        pasos += "\nEmpacada en " + empaque;
    }
}
