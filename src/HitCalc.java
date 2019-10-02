import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * The main interface of the application.
 */
public final class HitCalc {

    /**
     * The main method launching the application.
     *
     * @param args command-line arguments (not used)
     */
    public static final void main(String args[]) {
        final Scanner scanner = new Scanner(System.in);
        final DecimalFormat df = new DecimalFormat("#.##");

        System.out.print("Enemy's AC: ");
        final double ac = scanner.nextDouble();

        System.out.print("Mod: ");
        final double mod = scanner.nextDouble();

        final double probHit = (20 - ac + mod + 1) / 20;
        final double probMiss = (ac - 1) / 20;
        final double resultAdv = 1 - (probMiss * probMiss);
        final double resultDis = probHit * probHit;

        System.out.printf("Normal hit rate: %s\nAdvantage: %s - Disadvantage: %s\n",
                df.format(probHit), df.format(resultAdv), df.format(resultDis));
    }
}
