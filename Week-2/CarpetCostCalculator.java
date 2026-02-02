import java.util.Scanner;

public class CarpetCostCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length (in inches): ");
        double li = sc.nextDouble();

        System.out.print("Enter breadth (in inches): ");
        double bi = sc.nextDouble();

        System.out.print("Enter price per sq ft: ");
        double psf = sc.nextDouble();

        System.out.print("Enter discount (%): ");
        double d = sc.nextDouble();

        double lf = li / 12;
        double bf = bi / 12;

        double asf = lf * bf;
        double csp = asf * psf;

        System.out.println("Cost before discount: Rs " + csp);

        double da = (csp * d) / 100;
        double dsp = csp - da;

        System.out.println("Cost after discount: Rs " + dsp);

        sc.close();
    }
}
