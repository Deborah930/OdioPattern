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

class Guerriero implements Personaggio {
    private String name;
    private ContextStrategie strategy = new ContextStrategie();

    public Guerriero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void azione(Scanner intScanner) {
        scegliStrategia(intScanner);
        strategy.eseguiStrategia();

    }

    public void scegliStrategia(Scanner intScanner) {
        System.out.println("====MENU ATTACCO===");
        System.out.println("1. Attacco Melee");
        System.out.println("2. Attacco Magico");
        System.out.println("3. Attacco a Distanza");
        System.out.print("Scelta: ");
        int scelta = InputNumeri.ottieniInput(intScanner);
        switch (scelta) {
            case 1:
                strategy.setStrategy(new AttaccoMelee());
                break;
            case 2:
                strategy.setStrategy(new AttaccoMagico());
                break;
            case 3:
                strategy.setStrategy(new AttaccoDistanza());
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }

}

class Mago implements Personaggio {
    private String name;
    private ContextStrategie strategy = new ContextStrategie();

    public Mago(String name) {
        this.name = name;
    }

    @Override
    public void azione(Scanner intScanner) {
        scegliStrategia(intScanner);
        strategy.eseguiStrategia();

    }

    public String getName() {
        return name;
    }

    public void scegliStrategia(Scanner intScanner) {
        System.out.println("====MENU ATTACCO===");
        System.out.println("1. Attacco Melee");
        System.out.println("2. Attacco Magico");
        System.out.println("3. Attacco a Distanza");
        System.out.print("Scelta: ");
        int scelta = InputNumeri.ottieniInput(intScanner);
        switch (scelta) {
            case 1:
                strategy.setStrategy(new AttaccoMelee());
                break;
            case 2:
                strategy.setStrategy(new AttaccoMagico());
                break;
            case 3:
                strategy.setStrategy(new AttaccoDistanza());
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }

}

class Arciere implements Personaggio {
    private String name;
    private ContextStrategie strategy = new ContextStrategie();

    public Arciere(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void azione(Scanner intScanner) {
        scegliStrategia(intScanner);
        strategy.eseguiStrategia();

    }

    public void scegliStrategia(Scanner intScanner) {
        System.out.println("====MENU ATTACCO===");
        System.out.println("1. Attacco Melee");
        System.out.println("2. Attacco Magico");
        System.out.println("3. Attacco a Distanza");
        System.out.print("Scelta: ");
        int scelta = InputNumeri.ottieniInput(intScanner);
        switch (scelta) {
            case 1:
                strategy.setStrategy(new AttaccoMelee());
                break;
            case 2:
                strategy.setStrategy(new AttaccoMagico());
                break;
            case 3:
                strategy.setStrategy(new AttaccoDistanza());
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }

}

// 4. Creator: dichiara il Factory Method
abstract class CreatorePersonaggio {
    // Factory Method: restituisce un Product
    public abstract Personaggio istanziaPersonaggio(String name);

    // Un metodo del creator che utilizza il prodotto
    public Personaggio creaPersonaggio(String name) {
        Personaggio pg = istanziaPersonaggio(name); // creazione del prodotto
        return pg;
    }
}

// 5. ConcreteCreatorA: implementa factoryMethod per ConcreteProductA
class CreatoreGuerriero extends CreatorePersonaggio {
    @Override
    public Guerriero istanziaPersonaggio(String name) {
        return new Guerriero(name);
    }
}

// 6. ConcreteCreatorB: implementa factoryMethod per ConcreteProductB
class CreatoreMago extends CreatorePersonaggio {
    @Override
    public Mago istanziaPersonaggio(String name) {
        return new Mago(name);
    }
}

class CreatoreArciere extends CreatorePersonaggio {
    @Override
    public Arciere istanziaPersonaggio(String name) {
        return new Arciere(name);
    }
}