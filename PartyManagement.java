import java.util.ArrayList;
import java.util.List;

public class PartyManagement {
    
    // la ricezione dei danni avviene tramite il sistema di notifche

}

// serve a tenere conto dei personaggi una volta iniziata la sessione di gioco
class Squadra {
    private static List<Personaggio> squad;

    private Squadra() {
    }

    public List<Personaggio> getInstance() {
        if (squad == null) {
            return squad = new ArrayList<>();
        }
        return squad;
    }

    // per ora va bene giusto aggiungere membri del party
    public void addPartyMember(Personaggio pg) {
        squad.add(pg);
    }

    // metodo per ritornare solo un membro del party tramite posizione nella
    // squadra, scelta da sinistra a destra
    public Personaggio trovaMembro(int posizone) {
        Personaggio scelto = null;
        for (int i = 0; i < squad.size(); i++) {
            if (posizone == (i + 1)) {
                scelto = squad.get(i);

            }
        }
        return scelto;
    }

}
