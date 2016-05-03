/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial;

/**
 *
 * @author HéctorAugusto
 */
public class Marco {
    
    private double coordenadaX;
    private double coordenadaY;
    private Persona persona;

    public Marco(double coordenadaX, double coordenadaY, Persona persona) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.persona = persona;
    }

    @Override
    public String toString() {
        
        String persona = "Nombre: " + this.persona + "\n";
        String coordenadas = "Aparece en la foto en la coordenadas: (" + this.coordenadaX + ", " + this.coordenadaY + ")\n";
        return persona + coordenadas;
    }

    public Persona getPersona() {
        return persona;
    }
    
}
