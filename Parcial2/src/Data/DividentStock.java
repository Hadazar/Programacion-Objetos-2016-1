/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Usuario6
 */
public class DividentStock extends Stock{
    
    protected double dividens;

    public DividentStock(double dividens, int totalShare, String simbol, double totalCost, double CurrentPrice) {
        super(totalShare, simbol, totalCost, CurrentPrice);
        this.dividens = dividens;
    }
    
     public double getMarketValue(){
         
         return super.getMarketValue() + this.dividens;
     };
     
     public String toString(){
        
        String cash = "Asset: Divident stock\n\n";
        String symbol = "Symbol: " + this.simbol + "\n";
        String totalCost = "Total cost: " + this.totalCost + "\n";
        String currentPrice = "Current price: " + this.CurrentPrice + "\n";
        String totalShare = "Total share: " + this.totalShare + "\n";
        String dividens = "Dividens: " + this.dividens + "\n\n";
        
        return cash + symbol + totalCost + currentPrice + totalShare + dividens;
    }
}
