import java.util.InputMismatchException;
import java.util.Scanner;

public interface Personaggio {
    void azione(Scanner intScanner);

    String getName();
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

abstract class PersonaggioBase implements Personaggio {
    private String name;
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

    public abstract void displayMenuAttacchi();

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

    public void setStrategy(ContextStrategie strategy) {
        this.strategy = strategy;
    }
}

class Guerriero extends PersonaggioBase {
    private ContextStrategie strategy = new ContextStrategie();

    public Guerriero(String name) {
        super(name);
        setAttacco(3);
        setDestrezza(2);
        setPotereMagico(1);
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

class Arciere extends PersonaggioBase {
    private ContextStrategie strategy = new ContextStrategie();

    public Arciere(String name) {
        super(name);
        setAttacco(2);
        setDestrezza(3);
        setPotereMagico(1);
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
class CreatoreArciere extends CreatorePersonaggio {
    @Override
    public Arciere istanziaPersonaggio(String name) {
        return new Arciere(name);
    }
}