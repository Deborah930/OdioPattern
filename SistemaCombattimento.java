import java.util.ArrayList;

public class SistemaCombattimento {
    private InizializzazioneGioco initCorrente;
    private ArrayList<Personaggio> squadra;
    private Mostro mostro;

    public SistemaCombattimento(InizializzazioneGioco init) {
        this.initCorrente = init;
        this.squadra = init.getSquadra();
    }

    public void combattimentoPrincipale() {
        // il combattimento si ripete per tre volte
        for (int i = 0; i < 4; i++) {
            // questo metodo sceglie a caso un mostro da generare tramite il factory method
            // della classe Mostro
            System.out.println("++++++++++++++++++++NUOVA BATTAGLIA+++++++++++++++++++++");
            mostro = MostroBase.generazioneMostro();

            // questo metodo farà partire il combattimento vero e proprio
            combattimentoATurni(mostro);
        }

    }

    // metodo che inizia il combattimento a turni, prima ogni giocatore, poi il
    // mostro, ritorna la vittoria o la sconfitta come booleano
    private void combattimentoATurni(Mostro mostroDaCombattere) {
        // il ciclo si ripete fintantoché il mostro è in vita
        while (true) {
            mostroDaCombattere.displayMostroPortrait();
            initCorrente.displayPersonaggiScelti();
            for (Personaggio personaggio : squadra) {
                int dannoAMostro = personaggio.azione();
                mostroDaCombattere.setVita(dannoAMostro);
                if (mostroDaCombattere.getVita() <= 0) {
                    System.out.println("============================================================");
                    System.out.println("+++++++++++++++++++++MOSTRO SCONFITTO+++++++++++++++++++++++");
                    System.out.println("============================================================");
                    return;
                }
            }

        }
    }

}

// se tutti i membri del team hanno la vita 0 o se il mostro arriva a zero vita
// il combattimento termina
