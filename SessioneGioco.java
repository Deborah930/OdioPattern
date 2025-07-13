import java.util.ArrayList;

public class SessioneGioco {
    private ArrayList<Personaggio> squadra = Squadra.getInstance();
    private SceltaEroi scelta = new SceltaEroi();

    public void setTeam() {
        //istanzia le variabili da aggiungere alla squadra
        Personaggio pg1 = null;
        Personaggio pg2 = null;
        Personaggio pg3 = null;

        //lancia il metodo per scegliere definitivamente i personaggi
        pg1 = scelta.sceltaPersonaggioConNome();
        pg2 = scelta.sceltaPersonaggioConNome();
        pg3 = scelta.sceltaPersonaggioConNome();

        squadra.add(pg1);
        squadra.add(pg2);
        squadra.add(pg3);
    }

    // mostra le classi con un menù e poi selezioni Membro#1, Membro#2 e Membro#3
    // inizia la run, un mostro alla volta, 3 vs 1
    // inizio con 3 mostri max
}

// Scegliendo un personaggio lo si aggiunge al team di gioco (max 3 personaggi)
class SceltaEroi {
    // istanzio le variabili per la scelta degli eroi (si possono scegliere 2 ladri
    // e un mago, 3 guerrieri etc.)
    CreatoreGuerriero creatore1 = new CreatoreGuerriero();
    CreatoreMago creatore2 = new CreatoreMago();
    CreatoreLadro creatore3 = new CreatoreLadro();

    //display elementare per la scelta del nome
    public void displaySceltaNome() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║         SELEZIONE IL TUO NOME DI GIOCO (MAX 18 char)           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    //display elementare per la scelta della classe
    public void displaySceltaEroe() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                     SELEZIONE DELL'EROE                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        System.out.println("╔════════════════════╗╔════════════════════╗╔════════════════════╗");
        System.out.println("║   1. Guerriero     ║║     2. Mago        ║║     3. Ladro       ║");
        System.out.println("╚════════════════════╝╚════════════════════╝╚════════════════════╝");
        System.out.print("========= LA TUA SCELTA: ");
    }

    //metodo che ritorna un preciso personaggio dopo una selezione
    public Personaggio sceltaPersonaggioConNome() {
        Personaggio pg = null;
        String nome = null;
        int scelta = 0;
        while (nome == null || nome.trim().isEmpty()) {
            displaySceltaNome();
            nome = GlobalScanner.readStringInput();
        }

        while (scelta == 0) {
            displaySceltaEroe();
            scelta = InputNumeri.ottieniInput();
            switch (scelta) {
                case 1:
                    pg = creatore1.creaPersonaggio(nome);
                    break;
                case 2:
                    pg = creatore2.creaPersonaggio(nome);
                    break;
                case 3:
                    pg = creatore3.creaPersonaggio(nome);
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    scelta = 0;
                    break;
            }
        }
        return pg;
    }
}

class Portrait {
    // store the portrait inside some variables for now

    public ArrayList<String> guerrieroPortrait = new ArrayList<>();
    public ArrayList<String> magoPortrait = new ArrayList<>();
    public ArrayList<String> ladroPortrait = new ArrayList<>();

    public ArrayList<String> portraitGuerriero(ArrayList<String> portrait) {
        guerrieroPortrait.add(guerrieroLine1);// 1
        guerrieroPortrait.add(guerrieroLine2);// 2
        guerrieroPortrait.add(guerrieroLine3);// 3
        guerrieroPortrait.add(guerrieroLine4);// 4
        guerrieroPortrait.add(guerrieroLine5);// 5
        guerrieroPortrait.add(guerrieroLine6);// 6
        guerrieroPortrait.add(guerrieroLine7);// 7
        guerrieroPortrait.add(guerrieroLine8);// 8
        guerrieroPortrait.add(guerrieroLine9);// 9
        guerrieroPortrait.add(guerrieroLine10);// 10
        return this.guerrieroPortrait;
    }

    public ArrayList<String> portraitMago(ArrayList<String> portrait) {
        magoPortrait.add(mageLine1);// 1
        magoPortrait.add(mageLine2);// 2
        magoPortrait.add(mageLine3);// 3
        magoPortrait.add(mageLine4);// 4
        magoPortrait.add(mageLine5);// 5
        magoPortrait.add(mageLine6);// 6
        magoPortrait.add(mageLine7);// 7
        magoPortrait.add(mageLine8);// 8
        magoPortrait.add(mageLine9);// 9
        magoPortrait.add(mageLine10);// 10
        return magoPortrait;
    }

    public ArrayList<String> portraitLadro(ArrayList<String> portrait) {
        ladroPortrait.add(ladroLine1);// 1
        ladroPortrait.add(ladroLine2);// 2
        ladroPortrait.add(ladroLine3);// 3
        ladroPortrait.add(ladroLine4);// 4
        ladroPortrait.add(ladroLine5);// 5
        ladroPortrait.add(ladroLine6);// 6
        ladroPortrait.add(ladroLine7);// 7
        ladroPortrait.add(ladroLine8);// 8
        ladroPortrait.add(ladroLine9);// 9
        ladroPortrait.add(ladroLine10);// 10
        return ladroPortrait;
    }

    public String guerrieroLine1 = "╔════════════════════╗";
    public String guerrieroLine2 = "║   ▄▄▄████████▄▄▄   ║";
    public String guerrieroLine3 = "║  ▄██▄▄▄▄▄▄▄▄▄██▄   ║";
    public String guerrieroLine4 = "║ ▄██║  *   *  ║██▄  ║";
    public String guerrieroLine5 = "║ ███║    ║    ║███  ║";
    public String guerrieroLine6 = "║ ███║  ▄▄║▄▄  ║███  ║";
    public String guerrieroLine7 = "║ ███║▄▄▄▄▄▄▄▄▄║███  ║";
    public String guerrieroLine8 = "║  ██▄▄▄▄▄▄▄▄▄▄▄██   ║";
    public String guerrieroLine9 = "║   ▀████████████▀   ║";
    public String guerrieroLine10 = "╚════════════════════╝";

    // mage lines
    public String mageLine1 = "╔════════════════════╗";
    public String mageLine2 = "║     ▄███████▄▄     ║";
    public String mageLine3 = "║▄▄▄▄███████████▄▄▄▄▄║";
    public String mageLine4 = "║  ▄██▄       ▄██▄   ║";
    public String mageLine5 = "║ ▄██   *   *   ██▄  ║";
    public String mageLine6 = "║ ███     ║     ███  ║";
    public String mageLine7 = "║ ███   ▄▀▀▀▄   ███  ║";
    public String mageLine8 = "║  ██▄  ▀▀▀▀▀  ▄██   ║";
    public String mageLine9 = "║   ▀██▄▄▄▄▄▄▄██▀    ║";
    public String mageLine10 = "╚════════════════════╝";

    // ladro lines
    public String ladroLine1 = "╔════════════════════╗";
    public String ladroLine2 = "║     ▄▄▄▄▄▄▄▄▄      ║";
    public String ladroLine3 = "║   ▄███████████▄    ║";
    public String ladroLine4 = "║  ▄██▄       ▄██▄   ║";
    public String ladroLine5 = "║ ▄██   °   °   ██▄  ║";
    public String ladroLine6 = "║ ███     A     ███  ║";
    public String ladroLine7 = "║ ███           ███  ║";
    public String ladroLine8 = "║  ██▄  ▀▀▀▀▀  ▄██   ║";
    public String ladroLine9 = "║   ▀██▄▄▄▄▄▄▄██▀    ║";
    public String ladroLine10 = "╚════════════════════╝";
}

class DisplayEroi {
    private Portrait portraits = new Portrait();

    // sonno da inizializzare a ogni sessione
    Personaggio pg1;
    Personaggio pg2;
    Personaggio pg3;

    // devi usare anche questi setter quando crei un nuovo personaggio
    public void setPg1(Personaggio pg1) {
        this.pg1 = pg1;
    }

    public void setPg2(Personaggio pg2) {
        this.pg2 = pg2;
    }

    public void setPg3(Personaggio pg3) {
        this.pg3 = pg3;
    }


    //questo metodo printa in console i ritratti dei personaggi a prescindere di quale classe si sceglie
    public void displayCharactersFromLists() {
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    pg1.getPortrait().get(i) + pg2.getPortrait().get(i) + pg3.getPortrait().get(i));
        }
    }

    // metodo che accetta fino a un massimo di 20 caratteri
    public void displayCharactersNames() {
        System.out.println("╔════════════════════╗╔════════════════════╗╔════════════════════╗");
        System.out
                .println("║" + String.format("%20s", pg1.getName()) + "║║" + String.format("%20s", pg2.getName()) + "║║"
                        + String.format("%20s", pg3.getName()) + "║");

    }

    // metodo che mostra la vita dei personaggi
    public void displayStats() {
        System.out.println("╔════════════════════╗╔════════════════════╗╔════════════════════╗");
        System.out.println("║       " + pg1.getVita() + "/" + pg1.getVita() + "        ║       " + pg2.getVita() + "/"
                + pg2.getVita() + "        ║       " + pg3.getVita() + "/" + pg3.getVita() + "        ║");
        System.out.println("╚════════════════════╝╚════════════════════╝╚════════════════════╝");

    }
}
