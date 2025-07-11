import java.util.Scanner;

// Inizio Singleton e controllo del login
public class MenuPrincipale {

    Scanner intScanner;
    Scanner stringScanner;
    boolean uscita = false;
    Notificatore notificatore;
    Personaggio pg = null;
    String nomePersonaggio = null;

    // metodo per l'avvio del gioco
    public void avvioGioco() {
        // loop principale
        inizializzazione();

        while (!uscita) {
            System.out.println("=======MENU PRINCIPALE========");
            System.out.println("1. Inizia Partita");
            System.out.println("2. Carica Partita (ancora non ho idea come fare dati persistenti dateme tregua)");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");

            int scelta = InputNumeri.ottieniInput(intScanner);

            switch (scelta) {
                case 1:
                    System.out.println("+++++++INIO PARTITA+++++++++");
                    // metodo per far partire la successione di incontri
                    break;

                case 2:
                    System.out.println("Carica Partita non ancora implementato");
                    break;
                case 3:
                    uscita = true;
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        }
        intScanner.close();
    }

    public void inizializzazione() {
        intScanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
        notificatore = new Notificatore();
    }

}