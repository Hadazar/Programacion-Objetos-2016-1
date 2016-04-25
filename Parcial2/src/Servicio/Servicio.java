/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Dao.Dao;
import Data.Asset;
import Data.DividentStock;
import Data.Stock;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Usuario6
 */
public class Servicio {
    
    private Dao dao;
    private ArrayList<Asset> staffs;

    public Servicio() {
        this.dao = new Dao();
    }
    
    public void cargarAssets(String archivo) throws FileNotFoundException{
    
        staffs = this.dao.cargarArchivo(archivo);
    }
    
    public ArrayList<Asset> getAssets(){
        
        return this.staffs;
    }
    
    public double valorMercado_g_o_s(){
        
        double valorMercado = 0;
        
        for(Asset stuff : staffs){
            
            String clase = stuff.getClass().getName();
            if(clase.equals("Stock") || clase.equals("DividentStock")){
                Stock stock = (Stock)stuff;
                if(stock.getSimbol().equals("GOOGLE") || stock.getSimbol().equals("SAMSUMG")){
                    valorMercado += stock.getMarketValue();
                }
            }
        }
        
        return valorMercado;
    }
    
    public double[] valorBeneficioTotalMercado(){
        
        double[] valorBeneficioTotalMercado = new double[2];
        double valorTotalMercado = 0;
        double beneficioTotalMercado = 0;
        
        for(Asset stuff : staffs){
            
            valorTotalMercado += stuff.getMarketValue();
            beneficioTotalMercado += stuff.getProfit();
        }
        
        valorBeneficioTotalMercado[0] = valorTotalMercado;
        valorBeneficioTotalMercado[1] = beneficioTotalMercado;
        
        return valorBeneficioTotalMercado;
    }
}
