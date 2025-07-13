public class Main {
    public static void main(String[] args) {
        //la chiamata statica a GlobalScanner non va toccata
        GlobalScanner.InitScannerInputs();

        MenuPrincipale menu = new MenuPrincipale();

        menu.avvioGioco();

        GlobalScanner.CloseScannerInputs();
    }
}