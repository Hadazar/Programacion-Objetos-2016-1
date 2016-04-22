

package pizzeria;

/**
 * @HéctorDaza
 * @AndrésIriarte
 */
public class Queso extends Pizza {

    //Constructor de Queso
    public Queso(String masa, String salsa, String tipoCorte, String empaque, String imagen, double tiempoOrneado, String[] ingredientes, String pasos) {
        super(masa, salsa, tipoCorte, empaque, imagen, tiempoOrneado, ingredientes, pasos);
    }

    //Implementación de los metodos para Queso
    @Override
    public void preparar() {
        pasos += "\nLa pizza de Queso y amasando para obtener masa de tipo " + masa;
        pasos += "\nAdicionando salsa " + salsa;

        for (int i = 0; i < ingredientes.length; i++) {
            pasos += "\nAdicionando " + ingredientes[i];
        }
        ornear();
    }

    @Override
    public void ornear() {
        pasos += "\nHorneado por " + tiempoOrneado + "minutos";
        cortar();
    }

    @Override
    public void cortar() {
        pasos += "\nCorte " + tipoCorte;
        empacar();
    }

    @Override
    public void empacar() {
        pasos += "\nEmpacado en " + empaque + "\nÉsta pizza se preparó con Queso con 0% de colesterol ";
    }
}
