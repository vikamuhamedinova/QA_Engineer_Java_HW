public class Triangle extends Figure implements GeometricalCalculations {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2.0;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
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