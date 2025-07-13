public class Main {
    public static void main(String[] args) {
        //la chiamata statica a GlobalScanner non va toccata
        GlobalScanner.InitScannerInputs();

        SessioneGioco sessione = new SessioneGioco();

        sessione.setTeam();

        sessione.displayPersonaggiScelti();


    }
}