import java.util.ArrayList;

public interface Personaggio {
    int azione();

    String getName();

    int getVita();

    ArrayList<String> getPortrait();

    public void displayMenuAttacchi();
}

abstract class PersonaggioBase implements Personaggio {
    private String name;
    private int vita = 30;
    private int vitaRimanente = 30;
    private int attacco = 1;
    private int potereMagico = 1;
    private int destrezza = 1;
    protected ArrayList<String> portrait = new ArrayList<>();

    public PersonaggioBase(String name) {
        this.name = name;
    }

    @Override
    public int azione() {
        scegliStrategia();
        int danno = getStrategy().eseguiStrategia();
        return danno;

    }

    // switch case per la scelta della strategia

    public void scegliStrategia() {

        displayMenuAttacchi();

        int scelta = InputNumeri.ottieniInput();

        switch (scelta) {
            case 1:
                getStrategy().setStrategy(new AttaccoMelee(this));
                break;
            case 2:
                getStrategy().setStrategy(new AttaccoMagico(this));
                break;
            case 3:
                getStrategy().setStrategy(new AttaccoDistanza(this));
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }

    public abstract void setPortrait();

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

    public abstract ContextStrategie getStrategy();
}

class Guerriero extends PersonaggioBase {
    private ContextStrategie strategy = new ContextStrategie(this);

    public Guerriero(String name) {
        super(name);
        setAttacco(3);
        setDestrezza(2);
        setPotereMagico(1);
        setVita(50);
        setVitaRimanente(getVita());
        setPortrait();

    }

    @Override
    public int azione() {
        scegliStrategia();
        int danno = strategy.eseguiStrategia();
        return danno;

    }

    @Override
    public void displayMenuAttacchi() {
        System.out.println("╔═══════════════════╦══════════════════════╦═════════════════════╗");
        System.out.println("║    1. Spadata     ║    2.Aura Blade      ║    3. Boomerang     ║");
        System.out.println("╚═══════════════════╩══════════════════════╩═════════════════════╝");
    }

    @Override
    public void setPortrait() {
        Portrait newPortrait = new Portrait();
        portrait = newPortrait.portraitGuerriero(this.portrait);
    }

    @Override
    public ArrayList<String> getPortrait() {
        return this.portrait;
    }

    @Override
    public ContextStrategie getStrategy() {
        return this.strategy;
    }

}

class Mago extends PersonaggioBase {
    private ContextStrategie strategy = new ContextStrategie(this);

    public Mago(String name) {
        super(name);
        setAttacco(1);
        setDestrezza(2);
        setPotereMagico(3);
        setVita(35);
        setVitaRimanente(getVita());
        setPortrait();

    }

    @Override
    public int azione() {
        scegliStrategia();
        int danno = strategy.eseguiStrategia();
        return danno;

    }

    @Override
    public void displayMenuAttacchi() {
        System.out.println("╔═══════════════════╦══════════════════════╦═════════════════════╗");
        System.out.println("║ 1.Pugno di Fuoco  ║     2. Fulmine       ║   3. Magic Missile  ║");
        System.out.println("╚═══════════════════╩══════════════════════╩═════════════════════╝");
    }

    @Override
    public void setPortrait() {
        Portrait newPortrait = new Portrait();
        this.portrait = newPortrait.portraitMago(this.portrait);
    }

    @Override
    public ArrayList<String> getPortrait() {
        return this.portrait;
    }

    @Override
    public ContextStrategie getStrategy() {
        return this.strategy;
    }
}

class Ladro extends PersonaggioBase {
    private ContextStrategie strategy = new ContextStrategie(this);

    public Ladro(String name) {
        super(name);
        setAttacco(2);
        setDestrezza(3);
        setPotereMagico(1);
        setVita(40);
        setVitaRimanente(getVita());
        setPortrait();
    }

    @Override
    public int azione() {
        scegliStrategia();
        int danno = strategy.eseguiStrategia();
        return danno;

    }

    @Override
    public void displayMenuAttacchi() {
        System.out.println("╔═══════════════════╦══════════════════════╦═════════════════════╗");
        System.out.println("║   1. Pugnalata    ║    2.Sputa Veleno    ║   3. Lancia Lama    ║");
        System.out.println("╚═══════════════════╩══════════════════════╩═════════════════════╝");
    }

    @Override
    public void setPortrait() {
        Portrait newPortrait = new Portrait();
        this.portrait = newPortrait.portraitLadro(portrait);
    }

    @Override
    public ArrayList<String> getPortrait() {
        return this.portrait;
    }

    @Override
    public ContextStrategie getStrategy() {
        return this.strategy;
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