/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HéctorAugusto
 */
public class Hilo implements Runnable{
    
    private DataInputStream entrada;
    private Carro carro;

    public Hilo(DataInputStream entrada, Carro carro) {
        
        this.entrada = entrada;
        this.carro = carro;
    }

    @Override
    public void run() {
        
        while(true){
            
            try {
                
                int entrada = this.entrada.readInt();
                switch (entrada) {
                    
                    case 1: 
                        this.carro.setX(this.carro.getX() - 10);
                        break;
                    case 2: 
                        this.carro.setX(this.carro.getX() + 10); 
                        break;
                    case 3: 
                        this.carro.setY(this.carro.getY() - 10); 
                        break;
                    case 4: 
                        this.carro.setY(this.carro.getY() + 10); 
                        break;
              }
                
            } catch (IOException ex) {
                
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
