/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinar.el.numero;

/**
 *
 * @author HéctorAugusto
 */
public class AdivinarElNumero {

    public static void GuessingGame(){ 
        
        java.util.Scanner Leer = new java.util.Scanner(System.in); 

        int answer = (int)Math.floor((Math.random()*100)+1); 

        int guess = 0; 

        int numGuesses = 1; 

        while(numGuesses < 7 && (guess == answer)){ 

            System.out.println("Guess a number"); 

            guess = Leer.nextInt(); 

            if(guess < answer){ 

                System.out.println("Higher..."); 

            }else{ 

                if(guess > answer){ 

                    System.out.println("Lower"); 

                }else{System.out.println("You win");} 

            } 

        } 

        if(numGuesses > 7){ 

            System.out.println("You loser"); 

        } 

        Leer.close(); 

} 
    
    /**
     * @param args the command line arguments
     */
    public static void main (String []args){ 

        java.util.Scanner Leer = new java.util.Scanner(System.in); 

        String playAgain = "y"; 

        while(playAgain.equals('y')){ 

            GuessingGame(); 

            System.out.println("Would you like to play another game(y/n):"); 

            playAgain = Leer.next(); 

        } 

        Leer.close(); 

    } 

}
    

