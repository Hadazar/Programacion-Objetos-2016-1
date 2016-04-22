

package formas;

/**
 * @HéctorDaza
 * @AndrésIriarte
 */
public class Formas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle rectangulo = new Rectangle(8, 6);
        System.out.println("Area del rectangulo " + rectangulo.getArea()+" y perimetro del rectangulo " + rectangulo.getPerimeter()+" con altura "+rectangulo.height+" y ancho "+rectangulo.width+" con "+rectangulo.numSides+" lados");

        Triangle triangulo = new Triangle(30, 40);
        System.out.println("Area del triangulo " + triangulo.getArea()+" y perimetro del triangulo " + triangulo.getPerimeter()+" con altura "+triangulo.height+" y base "+triangulo.width+" con "+triangulo.numSides+" lados");
    }
}
