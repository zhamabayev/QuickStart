package lesson4;

public class TriangleData {
    private static double sideA;
    private static double sideB;
    private static double sideC;

    public static Double triangleSquare (double sideA, double sideB, double sideC) {
        double halfOfPerimeter = (sideA + sideB + sideC)/2;
        double square = Math.sqrt(halfOfPerimeter * (halfOfPerimeter - sideA)
        * (halfOfPerimeter - sideB) * (halfOfPerimeter - sideC));
        return square;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
}
