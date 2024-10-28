public class Rectangle extends Figure implements GeometricalCalculations {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (sideA + sideB);
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }

    @Override
    public void displayInfo() {
        System.out.print("[");
        System.out.print(calculatePerimeter() + ", ");
        System.out.print(calculateArea() + ", ");
        System.out.print(backgroundColor + ", ");
        System.out.println(borderColor + "]");
    }
}