

package formas;

/**
 * @HéctorDaza
 * @AndrésIriarte
 */
public class Rectangle extends Shape {

    public double width;
    public double height;

    public Rectangle(double width, double height) {
        super(4);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
       return width*height;
    }

    @Override
    public double getPerimeter() {
        return (width+height)*2;
    }
}
