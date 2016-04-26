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
            int numeroDecodificado = 0;
            if(numeroCifrado < 7){
                numeroDecodificado = (26 + (numeroCifrado-7));
            }else{
                numeroDecodificado = (numeroCifrado-7);
            }
            char letraOriginal = (char)(numeroDecodificado+65);
            palabraDescifrada += letraOriginal;
        }
        
        return palabraDescifrada;
    }
    
    public Cash leerCash(Scanner archivo){
        
        double amount = Double.parseDouble(archivo.next().trim());
        
        Cash cash = new Cash(amount);
        
        return cash;
    }
    
    public Stock leerStock(Scanner archivo){
        
        String palabra = archivo.next().trim();
        String simbol = this.desifrarPalabra(palabra);
        double totalCost = Double.parseDouble(archivo.next().trim());
        double currentPrice = Double.parseDouble(archivo.next().trim());
        int totalShare = archivo.nextInt();
        
        Stock stock = new Stock(totalShare, simbol, totalCost, currentPrice);
        
        return stock;
    }
    
    public DividentStock leerDividentStock(Scanner archivo){
        
        String palabra = archivo.next().trim();
        String simbol = this.desifrarPalabra(palabra);
        double totalCost = Double.parseDouble(archivo.next().trim());
        double currentPrice = Double.parseDouble(archivo.next().trim());
        int totalShare = archivo.nextInt();
        double dividents = Double.parseDouble(archivo.next().trim());
        
        DividentStock dividentStock = new DividentStock(dividents, totalShare, simbol, totalCost, currentPrice);
        
        return dividentStock;
    }
    public Asset leerStaff(Scanner archivo){
        
        String palabra = archivo.next().trim();
        String tipo = this.desifrarPalabra(palabra);
        Asset staff = null;
        
        if(tipo.equals("CASH")){
            staff = this.leerCash(archivo);
        }else if(tipo.equals("STOCK")){
            staff = this.leerDividentStock(archivo);
        }else if(tipo.equals("DIVSTOCK")){
            staff = this.leerStock(archivo);
        }
        
        return staff;
    }
    
    public ArrayList<Asset> cargarArchivo(String rutaArchivo) throws FileNotFoundException{
        
        ArrayList<Asset> staffs = new ArrayList<Asset>();
        Scanner archivo = new Scanner(new File(rutaArchivo));
        archivo.useDelimiter(",");
        
        while(archivo.hasNext()){
            staffs.add(this.leerStaff(archivo));
        }
        
        return staffs;
    }
}
