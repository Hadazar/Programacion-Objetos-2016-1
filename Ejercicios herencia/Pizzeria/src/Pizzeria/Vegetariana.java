

package pizzeria;

/**
 * @HéctorDaza
 * @AndrésIriarte
 */
public class Vegetariana extends Pizza {

    //Constructor de Vegetariana
    public Vegetariana(String masa, String salsa, String tipoCorte, String empaque, String imagen, double tiempoOrneado, String[] ingredientes, String pasos) {
        //Llama al constructor de Pizza para inicializar las variables
        super(masa, salsa, tipoCorte, empaque, imagen, tiempoOrneado, ingredientes, pasos);
    }

    //Implementación de los metodos para Vegetariana
    @Override
    public void preparar() {
        pasos += "\nLa pizza Vegetariana preparada y amasada para obtener masa de tipo " + masa;
        pasos += "\nAdicionando salsa " + salsa;

        for (int i = 0; i < ingredientes.length; i++) {
            pasos += "\nAdicionando " + ingredientes[i];
        }
        ornear();
    }

    @Override
    public void ornear() {
        pasos += "\nHorneada por " + tiempoOrneado+ "minutos";
        cortar();
    }

    @Override
    public void cortar() {
        pasos += "\nCorte " + tipoCorte;
        empacar();
    }

    @Override
    public void empacar() {
        pasos += "\nEmpacada en " + empaque+"\nÉsta Pizza está hecha con vegetales orgánicos";
    }
}
