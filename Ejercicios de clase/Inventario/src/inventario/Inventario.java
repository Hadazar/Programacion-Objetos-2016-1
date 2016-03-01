/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

/**
 *
 * @author HéctorAugusto
 */
public class Inventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Scanner Leer = new java.util.Scanner(System.in);
        
        String[] etiquetas = {"Nombre", "Tipo", "Cantidad Actual", "Tope mínimo de productos", "Precio base"};
        
        String[][] productos = new String[4][5];
        
        for(int i = 1; i < 4; i++){
            System.out.println("Producto "+ i +":");
            for(int j = 0; j < 3; j++){
                System.out.print(etiquetas[j]);
                productos[i][j] = Leer.nextLine();
            }
        }
        
        System.out.print("Escriba el nombre del producto con el que desea trabajar:");
        String nombre = Leer.nextLine();
        String[] informacion = informacionProducto(productos, nombre);
        
        System.out.println("Elija la operación a realizar:");
        System.out.println("a. Vender.");
        System.out.println("b. Hacer un pedido.");
        System.out.println("c. Conocer Las estadíticas.");
        
        char opcion = Leer.next().charAt(0);
        switch(opcion){
            case 'a': System.out.println("Cantidad del producto: ");
                break;
            case 'b': System.out.println("Cantidad del producto: ");
                break;
            case 'c': 
                break;
        };
      
    }
    
    public static String[] informacionProducto(String[][] productos, String nombre){
        int posicionProducto = 1;
        while(posicionProducto < 4){
            if(nombre.equals(productos[posicionProducto][0])){break;}
            posicionProducto++;
        }
        String[] informacion = productos[posicionProducto];
        return informacion;
    }
    
    public static double precioFinal(String precioBase){
        
        double impuesto = 0;
        double precio = Double.parseDouble(precioBase);
        switch(precioBase){
            case "papeleria": impuesto = 16/100;
                break;
            case "drogeria": impuesto = 12/100;
                break;
            case "supermercado": impuesto = 4/100;
                break;
        }
        double precioFinal = precio + precio * impuesto;
        return precioFinal;
    }
    
}
