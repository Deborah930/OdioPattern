
// interfaccia Strategy (può essere una classe astratta)
public interface StrategiaAttacco {
    int execute();
}

// strategie concrete, sono intercambiabili fra di loro (ovviamente fanno cose
// differenti)
class AttaccoMelee implements StrategiaAttacco {
    private Personaggio pg;

    public AttaccoMelee(Personaggio pg) {
        this.pg = pg;
    }

    @Override
    public int execute() {
        int dannoInflitto = 0;
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        if (pg instanceof Guerriero) {
            System.out.println("Il guerriero " + pg.getName() + " sferra una spadata");
            dannoInflitto = 3;
        } else if (pg instanceof Mago) {
            System.out.println("Il mago " + pg.getName() + " tira un pugno infuocato");
            dannoInflitto = 1;
        } else if (pg instanceof Ladro) {
            System.out.println("Il ladro " + pg.getName() + " pugnala l'avversario");
            dannoInflitto = 2;
        } else {
            System.out.println("Attacco Melee eseguito!");
        }
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        return dannoInflitto;
    }
}

class AttaccoMagico implements StrategiaAttacco {
    private Personaggio pg;

    public AttaccoMagico(Personaggio pg) {
        this.pg = pg;
    }

    @Override
    public int execute() {
        int dannoInflitto = 0;
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        if (pg instanceof Guerriero) {
            System.out.println("Il guerriero " + pg.getName() + " incanta la sua lama e attacca");
            dannoInflitto = 2;
        } else if (pg instanceof Mago) {
            System.out.println("Il mago " + pg.getName() + " congiura e lancia un fulmine");
            dannoInflitto = 3;
        } else if (pg instanceof Ladro) {
            System.out.println("Il ladro " + pg.getName() + " sputa del veleno");
            dannoInflitto = 1;
        } else {
            System.out.println("Attacco Magico eseguito!");
        }
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        return dannoInflitto;
    }
}

class AttaccoDistanza implements StrategiaAttacco {
    private Personaggio pg;

    public AttaccoDistanza(Personaggio pg) {
        this.pg = pg;
    }

    @Override
    public int execute() {
        int dannoInflitto = 0;
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        if (pg instanceof Guerriero) {
            System.out.println("Il guerriero " + pg.getName() + " lancia la sua spada contro il nemico");
            dannoInflitto = 1;
        } else if (pg instanceof Mago) {
            System.out.println("Il mago " + pg.getName() + " lancia Dardo Incantato");
            dannoInflitto = 2;
        } else if (pg instanceof Ladro) {
            System.out.println("Il ladro " + pg.getName() + " lancia un coltello");
            dannoInflitto = 3;
        } else {
            System.out.println("Attacco a Distanza eseguito!");
            dannoInflitto = 1;
        }
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        return dannoInflitto;
    }
}

// Context
class ContextStrategie {
    private StrategiaAttacco strategy;

    // Costruttore che imposta una strategia di default
    public ContextStrategie(Personaggio pg) {
        this.strategy = new AttaccoMelee(pg); // o altra strategia di default
    }

    public void setStrategy(StrategiaAttacco strategy) {
        this.strategy = strategy;
    }

    // performTask() esegue l'execute riferito all'oggetto nella variabile strategy.
    // poi quale variante di Strategy non è un problema che pesa su questo metodo
    public int eseguiStrategia() {
        int danno = strategy.execute();
        return danno;
    }
}