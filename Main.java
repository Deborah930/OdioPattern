public class Main {
    public static void main(String[] args) {
        //la chiamata statica a GlobalScanner non va toccata
        GlobalScanner.InitScannerInputs();

        InizializzazioneGioco init = new InizializzazioneGioco();

        init.setTeam();

        init.displayPersonaggiScelti();


    }
}