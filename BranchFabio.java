import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

// Definisce un'interfaccia per gli osservatori del gioco
interface OsservatoreGioco {

    // Metodo che verrà chiamato per aggiornare l'osservatore con un messaggio
    void aggiorna(String messaggio);
}

// Implementazione dell'interfaccia OsservatoreGioco per rappresentare un alleato
class Alleato implements OsservatoreGioco {
    
    // Nome dell'alleato
    private String nome;

    // Costruttore che inizializza il nome dell'alleato
    public Alleato(String nome) {
        this.nome = nome;
    }

    // Implementazione del metodo aggiorna che stampa il messaggio ricevuto
    @Override
    public void aggiorna(String messaggio) {
        System.out.println(nome + " ha ricevuto: " + messaggio);
    }
}

// Classe che gestisce la notifica agli osservatori
class Notificatore {
    
    // Lista di osservatori registrati
    private List<OsservatoreGioco> osservatori = new ArrayList<>();

    // Metodo per aggiungere un osservatore alla lista
    public void aggiungiOsservatore(OsservatoreGioco o) {
        osservatori.add(o);
    }

    // Metodo per rimuovere un osservatore dalla lista
    public void rimuoviOsservatore(OsservatoreGioco o) {
        osservatori.remove(o);
    }

    // Metodo per notificare tutti gli osservatori con un messaggio
    public void notificaTutti(String messaggio) {
        for (OsservatoreGioco o : osservatori) {
            o.aggiorna(messaggio);
        }
    }
}

// Definisce un'interfaccia per il pattern Decorator
interface Notifica {
    
    // Metodo che restituisce il messaggio decorato
    String getMessaggio();
}

// Implementazione base del Decorator che contiene solo il messaggio
class NotificaBase implements Notifica {
    
    // Contenuto del messaggio
    private String contenuto;

    // Costruttore che inizializza il contenuto del messaggio
    public NotificaBase(String contenuto) {
        this.contenuto = contenuto;
    }

    // Restituisce il contenuto del messaggio
    @Override
    public String getMessaggio() {
        return contenuto;
    }
}

// Decorator che aggiunge un timestamp al messaggio
class NotificaConTimestamp implements Notifica {
    
    // Riferimento al decorator da decorare
    private Notifica notifica;

    // Costruttore che riceve il decorator da decorare
    public NotificaConTimestamp(Notifica notifica) {
        this.notifica = notifica;
    }

    // Restituisce il messaggio con il timestamp
    @Override
    public String getMessaggio() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "[" + timestamp + "] " + notifica.getMessaggio();
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
}
        // Decorator che aggiunge un livello di allerta al messaggio
class NotificaConLivelloAllerta implements Notifica {
   
    // Riferimento al decorator da decorare
    private Notifica notifica;
    
    // Livello di allerta da aggiungere
    private String livello;

    // Formatter per la data e ora
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Costruttore che riceve il decorator da decorare e il livello di allerta
    public NotificaConLivelloAllerta(Notifica notifica, String livello) {
        this.notifica = notifica;
        this.livello = livello;
    }

    // Restituisce il messaggio con il livello di allerta
    @Override
    public String getMessaggio() {
        return "[Livello di attenzione: " + livello + "] " + notifica.getMessaggio();
    }
}


