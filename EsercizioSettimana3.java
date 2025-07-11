import java.util.Scanner;

public class EsercizioSettimana3 {

}
/*
 * 1. Login e Sessione Globale – Pattern Singleton
 * 
 * Crea un gestore SessionManager Singleton che mantiene lo stato della sessione
 * utente connesso.
 * 
 * Deve essere accessibile da tutta l'applicazione.
 */

// Inizio Singleton e controllo del login
class SessionManager {
    private static SessionManager istanza;// istanza del singleton
    private String userConnesso;// variabile per controllare l'utente che è connesso

    // costruttore privato per impedire istanziazioni esterne
    private SessionManager() {

    }

    // creazione dell'istanza unica di sessione
    public static SessionManager getIstanza() {
        if (istanza == null) {
            istanza = new SessionManager();
        }
        return istanza;
    }

    // metodo per il login dell'utente
    public void login(String username) {
        this.userConnesso = username;
        System.out.println("Utente loggato: " + username);
    }

    // metodo per il logout dell'utente
    public void logout() {
        System.out.println("Logout dell'utente:" + userConnesso);
        this.userConnesso = null;
    }

    // metodo per ottenere l'utente attualmente collegato
    public String getUserConnesso() {
        return userConnesso;
    }
}

// --------------------------------------------------------------------------------
/*
 * Comando di avvio/gioco – Pattern Facade
 * Implementa una classe GameEngineFacade che coordina avvio del gioco,
 * caricamento giocatore, impostazione strategia,
 * iscrizione alle notifiche e avvio partita.
 */
class GameEngineFacade {

    Scanner intScanner;
    Scanner stringScanner;
    boolean uscita = false;
    SessionManager sessione;
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

        // 1 registrazione login utente
        // 2 scelta del tipo di personaggio strategia d'attacco
        // 3 azione del giocatore
        // 4 invio notifiche
        // 5 output delle notifiche personalizzato
    }

    public void inizializzazione() {
        intScanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
        sessione = SessionManager.getIstanza();
        notificatore = new Notificatore();
    }

    public void sceltaPg() {
        System.out.println("Inserisci che tipo di giocatore vuoi usare: ");

        System.out.println("1. Guerriero");
        System.out.println("2. Mago");
        System.out.println("3. Arciere");

        int scelta2 = InputNumeri.ottieniInput(intScanner);
        switch (scelta2) {
            case 1:
                CreatorePersonaggio creatoreG = new CreatoreGuerriero();
                pg = creatoreG.creaPersonaggio(nomePersonaggio);
                break;
            case 2:
                CreatorePersonaggio creatoreM = new CreatoreMago();
                pg = creatoreM.creaPersonaggio(nomePersonaggio);
                break;
            case 3:
                CreatorePersonaggio creatoreA = new CreatoreArciere();
                pg = creatoreA.creaPersonaggio(nomePersonaggio);
                break;

            default:
                break;
        }
    }

}