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
public abstract class ShareAsset implements Asset{
    
    protected String simbol;
    protected double totalCost;
    protected double CurrentPrice;

    public ShareAsset(String simbol, double totalCost, double CurrentPrice) {
        this.simbol = simbol;
        this.totalCost = totalCost;
        this.CurrentPrice = CurrentPrice;
    }
    
    public abstract double getProfit();

    public String getSimbol() {
        return simbol;
    }
}
