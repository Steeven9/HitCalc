import java.text.DecimalFormat;
import java.util.*;

/**
 * The main interface of the application.
 */
public final class HitCalc {

    /**
     * The main method launching the application.
     *
     */
    public static final void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final DecimalFormat df = new DecimalFormat("#.##");

        double ac = 0;
        double mod = 0;

        System.out.println("Numbers only, 0 to exit");

        while (true) {
            System.out.print("\nEnemy's AC: ");
            try {
                ac = scanner.nextDouble();
            } catch (InputMismatchException ime) {
                System.out.println("NUMBERS ONLY YOU CUNT");
                System.exit(1);
            }

            if (ac == 0) {
                System.exit(0);
            }

            System.out.print("Mod: ");
            try {
                mod = scanner.nextDouble();
            } catch (InputMismatchException ime) {
                System.out.println("NUMBERS ONLY YOU CUNT");
                System.exit(1);
            }

            final double probHit = (20 - ac + mod + 1) / 20;
            final double probMiss = (ac - mod - 1) / 20;
            final double resultAdv = 1 - (probMiss * probMiss);
            final double resultDis = probHit * probHit;

            if (probHit <= 0) {
                System.out.println("Impossible to hit, unless you roll a 20");
            } else if (probHit >= 1) {
                System.out.println("Guaranteed hit, unless you roll a 1");
            } else {
                System.out.printf("Normal hit rate: %s\nAdvantage: %s - Disadvantage: %s\n",
                        df.format(probHit), df.format(resultAdv), df.format(resultDis));
            }
        }
    }
}
