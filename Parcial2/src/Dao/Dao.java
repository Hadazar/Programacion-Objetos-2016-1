/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Data.Asset;
import Data.Cash;
import Data.DividentStock;
import Data.Stock;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario6
 */
public class Dao {
    
    public String desifrarPalabra(String palabra){
        
        String palabraDescifrada = "";
        
        for(int i = 0; i < palabra.length(); i++){
            
            char letraCifrada = palabra.charAt(i);
            int numeroCifrado = (int)letraCifrada - 65;
            int numeroDecodificado = (numeroCifrado-7)%26 + 65;
            char letraOriginal = (char)numeroDecodificado;
            palabraDescifrada += letraOriginal;
        }
        
        return palabraDescifrada;
    }
    
    public Cash leerCash(Scanner archivo){
        
        double amount = archivo.nextDouble();
        
        Cash cash = new Cash(amount);
        
        return cash;
    }
    
    public Stock leerStock(Scanner archivo){
        
        String palabra = archivo.next().trim();
        String simbol = this.desifrarPalabra(palabra);
        double totalCost = archivo.nextDouble();
        double currentPrice = archivo.nextDouble();
        int totalShare = archivo.nextInt();
        
        Stock stock = new Stock(totalShare, simbol, totalCost, currentPrice);
        
        return stock;
    }
    
    public DividentStock leerDividentStock(Scanner archivo){
        
        String palabra = archivo.next().trim();
        String simbol = this.desifrarPalabra(palabra);
        double totalCost = archivo.nextDouble();
        double currentPrice = archivo.nextDouble();
        int totalShare = archivo.nextInt();
        double dividents = archivo.nextDouble();
        
        DividentStock dividentStock = new DividentStock(dividents, totalShare, simbol, totalCost, currentPrice);
        
        return dividentStock;
    }
    public Asset leerStaff(Scanner archivo){
        
        String palabra = archivo.next().trim();
        String tipo = this.desifrarPalabra(palabra);
        Asset stuff = null;
        
        if(tipo.equals("CASH")){
            stuff = this.leerCash(archivo);
        }else if(tipo.equals("STOCK")){
            stuff = this.leerStock(archivo);
        }else if(tipo.equals("DIVIDENTSTOCK")){
            stuff = this.leerDividentStock(archivo);
        }
        
        return stuff;
    }
    
    public ArrayList<Asset> cargarArchivo(String rutaArchivo) throws FileNotFoundException{
        
        ArrayList<Asset> stuffs = new ArrayList<Asset>();
        Scanner archivo = new Scanner(new File(rutaArchivo));
        archivo.useDelimiter(",");
        
        while(archivo.hasNext()){
            stuffs.add(this.leerStaff(archivo));
        }
        
        return stuffs;
    }
}
