import java.util.ArrayList;
import java.util.List;

// Definisce un'interfaccia per gli osservatori del gioco
interface Notificabile {

    // Metodo che verrà chiamato per aggiornare l'osservatore con un messaggio
    void riceveNotifica(Notifica notifica);

    void riceviDanno(Notifica notifica);
}

// Classe che gestisce la notifica agli osservatori
class Notificatore {

    // Lista di osservatori registrati
    private List<Notificabile> giocatoriTeam = new ArrayList<>(3);
    private Notificabile pgDanneggiato;

    // Metodo per aggiungere un osservatore alla lista
    public void aggiungiGiocatore(Notificabile o) {
        giocatoriTeam.add(o);
    }

    // Metodo per rimuovere un osservatore dalla lista
    public void rimuoviGiocatore(Notificabile o) {
        giocatoriTeam.remove(o);
    }

    // Metodo per notificare tutti gli osservatori con un messaggio
    public void mandaNotificaTutti(Notifica notifica) {
        for (Notificabile o : giocatoriTeam) {
            o.riceveNotifica(notifica);
        }
    }

    public void mandaDannoGiocatore(Notifica notifica) {
        pgDanneggiato.riceviDanno(notifica);
    }

    public void setPgDanneggiato(Notificabile pg) {
        this.pgDanneggiato = pg;
    }
}

// Definisce un'interfaccia per il pattern Decorator
interface Notifica {

    // Metodo che restituisce il messaggio decorato
    String getMessaggio();

    // metodo per restituire il danno della notifica
    int getDanno();
}

// Implementazione base del Decorator che contiene solo il messaggio
class NotificaBase implements Notifica {

    // Contenuto del messaggio
    private String contenuto;
    private int danno;

    // Costruttore che inizializza il contenuto del messaggio
    public NotificaBase(String contenuto, int danno) {
        this.contenuto = contenuto;
        this.danno = danno;

    }

    // Restituisce il contenuto del messaggio
    @Override
    public String getMessaggio() {
        return contenuto;
    }

    @Override
    public int getDanno() {
        return danno;
    }
}

// Decorator che aggiunge un colore al messaggio
class NotificaConColore implements Notifica {

    // Riferimento al decorator da decorare
    private Notifica notifica;

    // Costruttore che riceve il decorator da decorare
    public NotificaConColore(Notifica notifica) {
        this.notifica = notifica;
    }

    // Restituisce il messaggio colorato di verde usando codici ANSI
    @Override
    public String getMessaggio() {
        String verde = "\u001B[32m";
        String reset = "\u001B[0m";
        return verde + notifica.getMessaggio() + reset;
    }

    @Override
    public int getDanno() {
        return notifica.getDanno();
    }
}
