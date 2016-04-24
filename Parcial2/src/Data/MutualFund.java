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
public class MutualFund  extends ShareAsset{
    
    protected double totalShare;

    public MutualFund(double totalShare, String simbol, double totalCost, double CurrentPrice) {
        super(simbol, totalCost, CurrentPrice);
        this.totalShare = totalShare;
    }
    
    public double getMarketValue(){
        
        return this.totalCost * this.CurrentPrice;
    };
    
    public double getProfit(){
         
         return (this.totalShare * this.CurrentPrice) - this.totalCost;
     }
}
