import java.util.InputMismatchException;
import java.util.Scanner;

public interface Personaggio {
    void azione(Scanner intScanner);

    String getName();

    int getVita();
}

class InputNumeri {
    // metodo che gestisce l'input dell'utente
    static int ottieniInput(Scanner intScanner) {
        int scelta;
        // blocco try/catch per gestire l'input errato di qualcosa che non sia un numero
        // intero
        try {
            scelta = intScanner.nextInt();
        } catch (InputMismatchException e) {
            // messaggio di errore e reset del ciclo con scelta = 0
            System.out.println("Non è un numero riprova");
            intScanner.nextLine(); // libera il buffer consumando il new line "\n"
            scelta = 0;
        }

        return scelta;
    }
}

abstract class PersonaggioBase implements Personaggio, Notificabile {
    private String name;
    private int vita = 30;
    private int vitaRimanente = 30;
    private int attacco = 1;
    private int potereMagico = 1;
    private int destrezza = 1;
    private ContextStrategie strategy = new ContextStrategie();

    public PersonaggioBase(String name) {
        this.name = name;
    }

    @Override
    public void azione(Scanner intScanner) {
        scegliStrategia(intScanner);
        strategy.eseguiStrategia();

    }

    // switch case per la scelta della strategia

    public void scegliStrategia(Scanner intScanner) {

        displayMenuAttacchi();

        int scelta = InputNumeri.ottieniInput(intScanner);

        switch (scelta) {
            case 1:
                strategy.setStrategy(new AttaccoMelee(this));
                break;
            case 2:
                strategy.setStrategy(new AttaccoMagico(this));
                break;
            case 3:
                strategy.setStrategy(new AttaccoDistanza(this));
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }

    @Override
    public void riceveNotifica(Notifica notifica) {
        System.out.println(notifica.getMessaggio());

    }

    @Override
    public void riceviDanno(Notifica notifica) {
        System.out.println("Giocatore " + getName() + ": " + notifica.getDanno() + " danni ricevuti");

    }

    public abstract void displayMenuAttacchi();

    public int getVitaRimanente() {
        return vitaRimanente;
    }

    public void setVitaRimanente(int vitaRimanente) {
        this.vitaRimanente = vitaRimanente;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public int getPotereMagico() {
        return potereMagico;
    }

    public void setPotereMagico(int potereMagico) {
        this.potereMagico = potereMagico;
    }

    public int getDestrezza() {
        return destrezza;
    }

    public void setDestrezza(int destrezza) {
        this.destrezza = destrezza;
    }

    public ContextStrategie getStrategy() {
        return strategy;
    }
}

class Guerriero extends PersonaggioBase {
    private ContextStrategie strategy = new ContextStrategie();

    public Guerriero(String name) {
        super(name);
        setAttacco(3);
        setDestrezza(2);
        setPotereMagico(1);
        setVita(50);
        setVitaRimanente(getVita());
    }

    @Override
    public void azione(Scanner intScanner) {
        scegliStrategia(intScanner);
        strategy.eseguiStrategia();

    }

    @Override
    public void displayMenuAttacchi() {
        System.out.println("====MENU ATTACCO===");
        System.out.println("1. Spadata");
        System.out.println("2. Aura Blade Attack");
        System.out.println("3. Lancio della spada");
        System.out.print("Scelta: ");
    }

}

class Mago extends PersonaggioBase {
    private ContextStrategie strategy = new ContextStrategie();

    public Mago(String name) {
        super(name);
        setAttacco(1);
        setDestrezza(2);
        setPotereMagico(3);
        setVita(35);
        setVitaRimanente(getVita());
    }

    @Override
    public void azione(Scanner intScanner) {
        scegliStrategia(intScanner);
        strategy.eseguiStrategia();

    }

    @Override
    public void displayMenuAttacchi() {
        System.out.println("====MENU ATTACCO===");
        System.out.println("1. Pugno di Fuoco");
        System.out.println("2. Fulmine");
        System.out.println("3. Dardo Incantato");
        System.out.print("Scelta: ");
    }
}

class Ladro extends PersonaggioBase {
    private ContextStrategie strategy = new ContextStrategie();

    public Ladro(String name) {
        super(name);
        setAttacco(2);
        setDestrezza(3);
        setPotereMagico(1);
        setVita(40);
        setVitaRimanente(getVita());
    }

    @Override
    public void azione(Scanner intScanner) {
        scegliStrategia(intScanner);
        strategy.eseguiStrategia();

    }

    @Override
    public void displayMenuAttacchi() {
        System.out.println("====MENU ATTACCO===");
        System.out.println("1. Pugnalata");
        System.out.println("2. Freccia Incantata");
        System.out.println("3. Tiro di Precisione");
        System.out.print("Scelta: ");
    }
}

// 4. Creator: dichiara il Factory Method
abstract class CreatorePersonaggio {
    // Factory Method: restituisce un Personaggio
    public abstract Personaggio istanziaPersonaggio(String name);

    // Un metodo del creator che utilizza il personaggio
    public Personaggio creaPersonaggio(String name) {
        Personaggio pg = istanziaPersonaggio(name); // creazione del personagigo
        return pg;
    }
}

// CreatoreGuerriero: implementa istanziaPersonaggio
class CreatoreGuerriero extends CreatorePersonaggio {
    @Override
    public Guerriero istanziaPersonaggio(String name) {
        return new Guerriero(name);
    }
}

// CreatoreMago: implementa istanziaPersonaggio
class CreatoreMago extends CreatorePersonaggio {
    @Override
    public Mago istanziaPersonaggio(String name) {
        return new Mago(name);
    }
}

// creatoreArciere implementa istanziaPersonaggio
class CreatoreLadro extends CreatorePersonaggio {
    @Override
    public Ladro istanziaPersonaggio(String name) {
        return new Ladro(name);
    }
}