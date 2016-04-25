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
public class Cash implements Asset{
    
    protected double amount;

    public Cash(double amount) {
        this.amount = amount;
    }
   
    public double getMarketValue(){
        
        return amount;
    };
    
    public double getProfit(){
        
        return 0;
    };
    
    public String toString(){
        
        String cash = "Asset: Cash\n\n";
        String amount = "Amount: " + this.amount + "\n\n";
        
        return cash + amount;
    }
}
