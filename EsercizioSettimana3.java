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

    // metodo per l'avvio del gioco
    public void avvioGioco() {
        // loop principale
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        boolean uscita = false;
        SessionManager sessione = SessionManager.getIstanza();
        Notificatore notificatore = new Notificatore();
        Personaggio pg = null;
        String nomePersonaggio = null;

        while (!uscita) {
            System.out.println("Menu Gioco");
            System.out.println("1. login");
            System.out.println("2. Scelta personaggio");
            System.out.println("3. Esegui azione giocatore");
            System.out.println("4. Invio notifiche");
            System.out.println("5. exit");
            System.out.print("Scelta: ");

            if (!intScanner.hasNextInt()) {
                System.out.println("Input non valido! Inserisci un numero.");
                intScanner.next(); // Consuma l'input errato
                continue;
            }

            int scelta = intScanner.nextInt();
            intScanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    System.out.println("Registrazione..");
                    System.out.println("Inserire nome: ");
                    nomePersonaggio = stringScanner.nextLine();
                    sessione.login(nomePersonaggio);

                    break;

                case 2:
                    System.out.println("Inserisci che tipo di giocatore vuoi usare: ");

                    System.out.println("1. Guerriero");
                    System.out.println("2. Mago");
                    System.out.println("3. Arciere");

                    notificatore.aggiungiOsservatore(new Alleato(nomePersonaggio));
                    int scelta2 = intScanner.nextInt();
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
                    notificatore.aggiungiOsservatore(new Alleato(nomePersonaggio));
                    break;

                case 3:
                    pg.azione(intScanner);
                    break;
                case 4:
                    notificatore.notificaTutti(pg.getName());
                    break;

                case 5:
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

}