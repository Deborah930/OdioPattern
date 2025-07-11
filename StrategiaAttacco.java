
// interfaccia Strategy (può essere una classe astratta)
public interface StrategiaAttacco {
    void execute();
}

// strategie concrete, sono intercambiabili fra di loro (ovviamente fanno cose
// differenti)
class AttaccoMelee implements StrategiaAttacco {
    private Personaggio pg;

    public AttaccoMelee(Personaggio pg) {
        this.pg = pg;
    }

    @Override
    public void execute() {
        if (pg instanceof Guerriero) {
            System.out.println("Il guerriero " + pg.getName() + " sferra una spadata");
        } else if (pg instanceof Mago) {
            System.out.println("Il mago " + pg.getName() + " tira un pugno infuocato");
        } else if (pg instanceof Ladro) {
            System.out.println("Il ladro " + pg.getName() + " pugnala l'avversario");
        } else {
            System.out.println("Attacco Melee eseguito!");

        }
    }
}

class AttaccoMagico implements StrategiaAttacco {
    private Personaggio pg;

    public AttaccoMagico(Personaggio pg) {
        this.pg = pg;
    }

    @Override
    public void execute() {
        if (pg instanceof Guerriero) {
            System.out.println("Il guerriero " + pg.getName() + " incanta la sua lama e attacca");
        } else if (pg instanceof Mago) {
            System.out.println("Il mago " + pg.getName() + " congiura e lancia un fulmine");
        } else if (pg instanceof Ladro) {
            System.out.println("Il ladro " + pg.getName() + " sputa del veleno");
        } else {
            System.out.println("Attacco Magico eseguito!");

        }
    }
}

class AttaccoDistanza implements StrategiaAttacco {
    private Personaggio pg;

    public AttaccoDistanza(Personaggio pg) {
        this.pg = pg;
    }

    @Override
    public void execute() {
        if (pg instanceof Guerriero) {
            System.out.println("Il guerriero " + pg.getName() + " lancia la sua spada contro il nemico");
        } else if (pg instanceof Mago) {
            System.out.println("Il mago " + pg.getName() + " lancia Dardo Incantato");
        } else if (pg instanceof Ladro) {
            System.out.println("Il ladro " + pg.getName() + " prende la mira lancia un coltello");
        } else {
            System.out.println("Attacco a Distanza eseguito!");

        }
    }
}

// Context
class ContextStrategie {
    private StrategiaAttacco strategy;

    public void setStrategy(StrategiaAttacco strategy) {
        this.strategy = strategy;
    }

    // performTask() esegue l'execute riferito all'oggetto nella variabile strategy.
    // poi quale variante di Strategy non è un problema che pesa su questo metodo
    public void eseguiStrategia() {
        strategy.execute();
    }
}