public class Main {
    public static void main(String[] args) {
        //la chiamata statica a GlobalScanner non va toccata
        GlobalScanner.InitScannerInputs();
        DisplayEroi display = new DisplayEroi();

        CreatoreGuerriero creatore1 = new CreatoreGuerriero();
        CreatoreLadro creatore2 = new CreatoreLadro();
        CreatoreMago creatore3 = new CreatoreMago();

        display.setPg1(creatore1.creaPersonaggio("Giovanni"));
        display.setPg2(creatore2.creaPersonaggio("Roberto"));
        display.setPg3(creatore3.creaPersonaggio("Giancarlo"));

        // display.displayAllCharacters();
        display.displayCharactersNames();
        display.displayCharactersFromLists();

    }
}