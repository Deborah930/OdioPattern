import java.util.ArrayList;

public class SistemaCombattimento {
    private ArrayList<Personaggio> squadra;
    private Mostro mostro;

    public SistemaCombattimento(ArrayList<Personaggio> newSquadra) {
        this.squadra = newSquadra;
    }

    public void combattimentoPrincipale() {
        // il combattimento si ripete per tre volte
        for (int i = 0; i < 4; i++) {

        }
        // questo metodo sceglie a caso un mostro da generare tramite il factory method
        // della classe Mostro
        mostro = MostroBase.generazioneMostro();

        // questo metodo farà partire il combattimento vero e proprio
        combattimentoATurni(mostro);
    }

    private void combattimentoATurni(Mostro mostroDaCombattere) {

        while ((squadra.get(0).getVita() > 0 || squadra.get(0).getVita() > 0 || squadra.get(0).getVita() > 0)
                || mostroDaCombattere.getVita() > 0) {

        }
    }

}

// se tutti i membri del team hanno la vita 0 o se il mostro arriva a zero vita
// il combattimento termina
