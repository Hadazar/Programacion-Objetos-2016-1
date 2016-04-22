

package pizzeria;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @HéctorDaza
 * @AndrésIriarte
 */
public class Pizzeria {

    //Este array se utiliza para introducir los ingredientes
    public String[] ingredientes;
    //Objeto de tipo Pizza utilizado para instanciar la clase Vegetariana, Pepperoni, Queso
    public Pizza pizza;
    //Contiene los textos a mostrar en los mensajes
    public String informacionParaCliente;
    //Contiene la ruta de las imagenes de cada Pizza
    public String imagenPizza;
    //Se crea una variable de tipo Integer para contener el valor de la pizza seleccionada
    Integer pizzaSeleccionada;

    /**
     * Constructor inicializa las variables
     */
    public Pizzeria() {
        informacionParaCliente = "";
        pizzaSeleccionada = 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inicializa la clase Pizzeria
        Pizzeria pizzeria;
        pizzeria = new Pizzeria();

        //Este While mostrará el mensaje de selección 
        while (pizzeria.pizzaSeleccionada != 4) {
            //Mensaje para que el usuario introduzca el tipo de pizza que desea
            pizzeria.pizzaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido\nSeleccione el tipo de pizza que desea\n1. Vegetariana\n2. Pepperoni\n3. Queso\n4. Salir"));
            //Llama al metodo seleccionarPizza y le envia la pizza seleccionada
            pizzeria.seleccionarPizza(pizzeria.pizzaSeleccionada);
            //Muestra la respuesta para la pizza seleccionada
            JOptionPane.showMessageDialog(null, pizzeria.informacionParaCliente, "La Pizzeria", 1, new ImageIcon(pizzeria.imagenPizza));
        }

    }

    public void seleccionarPizza(Integer tipoPizza) {
        //Inicializa la variable para que no se acumulen los resultados de los pasos y para tener un texto común a todas las opiciones
        informacionParaCliente = "Estimado Cliente: ";

        //Si el parametro tipoPizza es igual a 1 se envian paramtros para la pizza Vegetariana
        if (tipoPizza == 1) {
            //Se crea el array de String con 6 campos para cada ingrediente
            ingredientes = new String[6];
            //Se introduce cada ingrediente en el array
            ingredientes[0] = "Mozzarella";
            ingredientes[1] = "Parmesano rallado";
            ingredientes[2] = "Cebolla picada";
            ingredientes[3] = "Hongos en rebanadas";
            ingredientes[4] = "Pimienta roja en rodajas";
            ingredientes[5] = "Aceitunas negras rebanadas";
            //Se instancia la clase Vegetariana y se envian los parametros correspondientes
            pizza = new Vegetariana("Regular", "Tomate", "Tradicional", "Caja de cartón", "vegetariana", 10, ingredientes, "");
            //Se inicia la preparación de la pizza llamando al metodo preparar()
            pizza.preparar();
            //El resultado de los pasos de la elaboración de la pizza se introducen en la variable informacionParaCliente
            informacionParaCliente += pizza.pasos;
            //La imagen de la pizza se introduce en la variable imagenPizza
            imagenPizza = pizza.imagen;
        } else if (tipoPizza == 2) {
            //Se crea el array de String con 3 campos para cada ingrediente
            ingredientes = new String[3];
            //Se introduce cada ingrediente en el array
            ingredientes[0] = "Rodajas de pepperoni";
            ingredientes[1] = "Rodajas de cebolla";
            ingredientes[2] = "Queso parmesano rallado";
            //Se instancia la clase Peperoni y se envian los parametros correspondientes
            pizza = new Peperoni("Regular", "Tomate", "Español", "Icopor", "pepperoni", 15, ingredientes, "");
            //Se inicia la preparación de la pizza llamando al metodo preparar()
            pizza.preparar();
            //El resultado de los pasos de la elaboración de la pizza se introducen en la variable informacionParaCliente
            informacionParaCliente += pizza.pasos;
            //La imagen de la pizza se introduce en la variable imagenPizza
            imagenPizza = pizza.imagen;
        } else if (tipoPizza == 3) {
            //Se crea el array de String con 2 campos para cada ingrediente
            ingredientes = new String[2];
            ingredientes[0] = "Queso Mozzarella fresco";
            ingredientes[1] = "Parmesano";
            //Se introduce cada ingrediente en el array
            pizza = new Queso("Corteza regular", "Tomate", "Italiano", "Icopor", "queso", 18, ingredientes, "");
            //Se inicia la preparación de la pizza llamando al metodo preparar()
            pizza.preparar();
            //El resultado de los pasos de la elaboración de la pizza se introducen en la variable informacionParaCliente
            informacionParaCliente += pizza.pasos;
            //La imagen de la pizza se introduce en la variable imagenPizza
            imagenPizza = pizza.imagen;
        } else if (tipoPizza == 4) {
            //En caso de salida del programa se pone por defecto la imagen salida.jpg
            imagenPizza = "src/pizzeria/image/salida.jpg";
            //Se escribe un mensaje en informacionParaCliente relacionado a la salida del programa
            informacionParaCliente += "Hasta la próxima!!!";
        } else {
            //En caso de introducir un valor invalido en el programa se pone por defecto la imagen incorrecto.jpg
            imagenPizza = "src/pizzeria/image/incorrecto.jpg";
            //Se escribe un mensaje en informacionParaCliente relacionado al ingreso de datos invalidos al programa
            informacionParaCliente += "Lo sentimos pero no seleccionó una pizza válida";
        }
    }
}
