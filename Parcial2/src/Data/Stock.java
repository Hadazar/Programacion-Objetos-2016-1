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
public class Stock extends ShareAsset{
    
    protected int totalShare;

    public Stock(int totalShare, String simbol, double totalCost, double CurrentPrice) {
        super(simbol, totalCost, CurrentPrice);
        this.totalShare = totalShare;
    }
    
     public double getMarketValue(){
         
         return this.totalCost * this.CurrentPrice;
     };
     
     public double getProfit(){
         
         return (this.totalShare * this.CurrentPrice) - this.totalCost;
     }
     
     public String toString(){
        
        String cash = "Asset: Stock\n\n";
        String symbol = "Symbol: " + this.simbol + "\n";
        String totalCost = "Total cost: " + this.totalCost + "\n";
        String currentPrice = "Current price: " + this.CurrentPrice + "\n";
        String totalShare = "Total share: " + this.totalShare + "\n";
        return cash + symbol + totalCost + currentPrice + totalShare;
    }
}
