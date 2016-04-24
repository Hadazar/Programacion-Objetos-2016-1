/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Data.Asset;
import Servicio.Servicio;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario6
 */
public class UI {
    
    private Scanner archivo;
    private Servicio servicio;
    
    public UI(){
        archivo = new Scanner(System.in);
        this.servicio = new Servicio();
    }
    
    public void imprimirAssets(ArrayList<Asset> staffs){
        
        if(staffs != null){
            
            for(Asset stuff : staffs){
                System.out.println(stuff);
            }
        }else{
            System.out.println("No se ha cargado nigún dato");
        }
    }
    
    public void menu(){
        
        int opcion = 0;
        System.out.println("Opciones:\n");
        System.out.println("1. Leer datos encriptados.\n2. Listar todos los asset.");
        System.out.println("3. Determinar el valor total en el mercado de todas las stock y divident stock de Google o samsumg");
        System.out.println("4. Determinar el valor total y el beneficio total de los tipos de Asset");
        
        switch(opcion){
            
            case 1:
                System.out.print("Nombre del archivo: ");
                String rutaArchivo = this.archivo.next();
                System.out.println("");
                try{
                    this.servicio.cargarAssets(rutaArchivo);
                }catch(FileNotFoundException e){
                    System.out.println("No existe un archivo con el nombre especificado");
                }
                break;
            case 2:
                ArrayList<Asset> staffs = this.servicio.getAssets();
                System.out.println("Assets:\n");
                this.imprimirAssets(staffs);
                break;
            case 3:
                double valorTotal = this.servicio.valorMercado_g_o_s();
                System.out.println("Valor total: " + valorTotal);
                
                break;
            case 4:
                double[] valorTotal2 = this.servicio.valorBeneficioTotalMercado();
                System.out.println("Valor total: " + valorTotal2[0]);
                System.out.println("Beneficio total: " + valorTotal2[1]);
                break;
            default:
                System.out.println("Opcion inválida");
        }
    }
}
