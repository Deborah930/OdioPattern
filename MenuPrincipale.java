// Inizio Singleton e controllo del login
public class MenuPrincipale {

    boolean uscita = false;
    Notificatore notificatore;
    String nomePersonaggio = null;

    // metodo per l'avvio del gioco
    public void avvioGioco() {
        // loop principale
        inizializzazione();
        int scelta = 0;

        while (scelta == 0) {
            displayMenuPrincipale();

            scelta = InputNumeri.ottieniInput();

            switch (scelta) {
                case 1:
                    System.out.println("+++++++INIO PARTITA+++++++++");
                    // metodo per far partire la scelta del team e poi le battaglie
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
                    scelta = 0;
            }
        }
    }

    public void displayMenuPrincipale() {
        System.out.println("=======MENU PRINCIPALE========");
        System.out.println("1. INIZIA PARTITA");
        System.out.println("2. CARICA PARTITA (ancora non ho idea come fare dati persistenti dateme tregua)");
        System.out.println("3. ESCI");
        System.out.print("Scelta: ");
    }

    public void inizializzazione() {
        notificatore = new Notificatore();
    }

}