import java.util.InputMismatchException;
import java.util.Scanner;

public class GlobalScanner {
    private static Scanner numScanner = null;
    private static Scanner stringScanner = null;

    public static void InitScannerInputs() {
        numScanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
    }

    public static int readIntInput() {
        return numScanner == null ? 0 : numScanner.nextInt();
    }

    public static String readStringInput() {
        return stringScanner == null ? "" : stringScanner.nextLine();
    }

    public static void CloseScannerInputs() {
        numScanner.close();
        stringScanner.close();
    }

    public static void clearIntBuffer() {
        numScanner.nextLine(); // Consuma l'input non valido rimasto nel buffer del main
    }

    public static void clearStringBuffer() {
        stringScanner.nextLine(); // Consuma l'input non valido rimasto nel buffer del main
    }
}

class InputNumeri {
    // metodo che gestisce l'input dell'utente
    public static int ottieniInput() {
        int scelta;
        // blocco try/catch per gestire l'input errato di qualcosa che non sia un numero
        // intero
        try {
            scelta = GlobalScanner.readIntInput();
        } catch (InputMismatchException e) {
            // messaggio di errore e reset del ciclo con scelta = 0
            System.out.println("Non è un numero riprova");
            GlobalScanner.clearIntBuffer();
            ; // libera il buffer consumando il new line "\n"
            scelta = 0;
        }

        return scelta;
    }
}