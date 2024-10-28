public class Circle extends Figure implements GeometricalCalculations {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
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