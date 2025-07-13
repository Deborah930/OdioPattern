// Inizio Singleton e controllo del login
public class MenuPrincipale {
    private InizializzazioneGioco init = new InizializzazioneGioco();
    private SistemaCombattimento combat;

    // metodo per l'avvio del gioco
    public void avvioGioco() {
        int scelta = 0;
        // loop principale retto sulla scelta iniziale
        while (scelta == 0) {
            displayMenuPrincipale();

            scelta = InputNumeri.ottieniInput();

            // ogni case ritorna la scelta a 0 in modo da non terminare automaticamente
            // il programma quando si esce dalla sessione di gioco
            switch (scelta) {
                case 1:
                    System.out.println("+++++++++++++++++++INIZIO PARTITA+++++++++++++++++");

                    // scelta del team, chiamare sempre all'inizio ho il meccanismo di combattimento
                    // non si avvierà mai, lancerà un NullPointerException al richiamo dei suoi
                    // metodi di istanza
                    init.setTeam();

                    // INIZIO
                    // a questo punto i personaggi sono stati settati e il combattimento può
                    // avviarsi
                    combat = new SistemaCombattimento(init);
                    combat.combattimentoPrincipale();

                    scelta = 0;
                    break;
                case 2:
                    System.out.println("Carica Partita non ancora implementato");
                    scelta = 0;
                    break;
                case 3:
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

}