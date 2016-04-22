

package formas;

/**
 * @HéctorDaza
 * @AndrésIriarte
 */
public abstract class Shape {

    public Integer numSides;
    
    public Shape(Integer numSides) {
        this.numSides = numSides;
    }
    //Metodo Concreto
    public Integer getNumSides() {
        return numSides;
    }
    
    //Metodos Abstractos
    public abstract double getArea();
    public abstract double getPerimeter();
}
