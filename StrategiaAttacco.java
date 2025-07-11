

// interfaccia Strategy (può essere una classe astratta)
public interface StrategiaAttacco {
    void execute();
}

// strategie concrete, sono intercambiabili fra di loro (ovviamente fanno cose differenti)
class AttaccoMelee implements StrategiaAttacco {
    @Override
    public void execute() {
        System.out.println("Attacco Melee eseguito! KAPOOOWWWW!!!");
    }
}

class AttaccoMagico implements StrategiaAttacco {
    @Override
    public void execute() {
        System.out.println("Attacco Magico eseguito! BLIZZAGA!");
    }
}

class AttaccoDistanza implements StrategiaAttacco {
    @Override
    public void execute() {
        System.out.println("Attacco a Distanza eseguito! CIABATTA DELLA MAMMA!");
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