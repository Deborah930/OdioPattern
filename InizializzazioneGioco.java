import java.util.ArrayList;

public class InizializzazioneGioco {
    // inizializzazione lista, una per sessione squadra, tramite "squadra" richiami
    // tutti i metodi per la gestione dei personaggi
    private ArrayList<Personaggio> squadra;

    // serve per avere accesso ai metodi di creazione
    private SceltaEroi scelta;

    // per settare i ritratti a seconda delle scelte dell'utente
    private DisplayEroi display;

    public InizializzazioneGioco() {
        squadra = Squadra.getInstance();
        scelta = new SceltaEroi();
        display = new DisplayEroi();
    }

    public void setTeam() {
        // istanzia le variabili da aggiungere alla squadra
        Personaggio pg1 = null;
        Personaggio pg2 = null;
        Personaggio pg3 = null;

        // lancia il metodo per scegliere definitivamente i personaggi
        pg1 = scelta.sceltaPersonaggioConNome();
        pg2 = scelta.sceltaPersonaggioConNome();
        pg3 = scelta.sceltaPersonaggioConNome();

        // aggiungi i pg alla squadra
        squadra.add(pg1);
        squadra.add(pg2);
        squadra.add(pg3);

        // setta il diplsay dei personaggi
        display.setPg1(pg1);
        display.setPg2(pg2);
        display.setPg3(pg3);
    }

    // metodo per ritornare tutti i personaggi scelti fin'ora per comunicare con le
    // altre classi, da richiamare solo **DOPO** l'aver chiamato il metodo setTeam()
    public ArrayList<Personaggio> getSquadra() {
        return squadra;
    }

    // mostra le classi con un menù e poi selezioni Membro#1, Membro#2 e Membro#3

    public void displayPersonaggiScelti() {
        display.displayCharactersNames();
        display.displayCharactersFromLists();
        display.displayStats();
    }
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

    // display elementare per la scelta del nome
    public void displaySceltaNome() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║            INSERISCI UN NOME VALIDO (MAX 18 char)              ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    // display elementare per la scelta della classe
    public void displaySceltaEroe() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                     SELEZIONE DELL'EROE                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        System.out.println("╔════════════════════╗╔════════════════════╗╔════════════════════╗");
        System.out.println("║   1. Guerriero     ║║     2. Mago        ║║     3. Ladro       ║");
        System.out.println("╚════════════════════╝╚════════════════════╝╚════════════════════╝");
        System.out.print("========= LA TUA SCELTA: ");
    }

    // metodo che ritorna un preciso personaggio dopo una selezione
    public Personaggio sceltaPersonaggioConNome() {
        Personaggio pg = null;
        String nome = null;
        int scelta = 0;

        // sezione per la scelta del nome in modo che non sia vuoto o superiore ai 18
        // caratteri
        do {
            displaySceltaNome(); // metodo per il menu
            nome = GlobalScanner.readStringInput();
        } while (nome == null || nome.trim().isEmpty() || nome.length() > 18);

        // sezione per la scelta della classe con gestione della casistica tramite
        // switch case
        while (scelta == 0) {
            displaySceltaEroe(); // metodo per il menu
            scelta = InputNumeri.ottieniInput();
            switch (scelta) {
                case 1: // crea un guerriero
                    pg = creatore1.creaPersonaggio(nome);
                    break;
                case 2: // crea un mago
                    pg = creatore2.creaPersonaggio(nome);
                    break;
                case 3: // crea un ladro
                    pg = creatore3.creaPersonaggio(nome);
                    break;

                default:
                    // gestisce un input non valido e ritorna all'inizio del loop con "scelta = 0;"
                    System.out.println("Scelta non valida. Riprova.");
                    scelta = 0;
                    break;
            }
        }

        // per forza di cosa ritorna un pg valido dopo il while loop
        return pg;
    }
}

// classe che gestisce l'inizializzazione dei ritratti dei personaggi in modo
// che si possano accettare scelte multiple
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

    public String guerrieroLine1 = "╟════════════════════╢";
    public String guerrieroLine2 = "║   ▄▄▄████████▄▄▄   ║";
    public String guerrieroLine3 = "║  ▄██▄▄▄▄▄▄▄▄▄██▄   ║";
    public String guerrieroLine4 = "║ ▄██║  *   *  ║██▄  ║";
    public String guerrieroLine5 = "║ ███║    ║    ║███  ║";
    public String guerrieroLine6 = "║ ███║  ▄▄║▄▄  ║███  ║";
    public String guerrieroLine7 = "║ ███║▄▄▄▄▄▄▄▄▄║███  ║";
    public String guerrieroLine8 = "║  ██▄▄▄▄▄▄▄▄▄▄▄██   ║";
    public String guerrieroLine9 = "║   ▀████████████▀   ║";
    public String guerrieroLine10 = "╟════════════════════╢";

    // mage lines
    public String mageLine1 = "╟════════════════════╢";
    public String mageLine2 = "║     ▄███████▄▄     ║";
    public String mageLine3 = "║▄▄▄▄███████████▄▄▄▄▄║";
    public String mageLine4 = "║  ▄██▄       ▄██▄   ║";
    public String mageLine5 = "║ ▄██   *   *   ██▄  ║";
    public String mageLine6 = "║ ███     ║     ███  ║";
    public String mageLine7 = "║ ███   ▄▀▀▀▄   ███  ║";
    public String mageLine8 = "║  ██▄  ▀▀▀▀▀  ▄██   ║";
    public String mageLine9 = "║   ▀██▄▄▄▄▄▄▄██▀    ║";
    public String mageLine10 = "╟════════════════════╢";

    // ladro lines
    public String ladroLine1 = "╟════════════════════╢";
    public String ladroLine2 = "║     ▄▄▄▄▄▄▄▄▄      ║";
    public String ladroLine3 = "║   ▄███████████▄    ║";
    public String ladroLine4 = "║  ▄██▄       ▄██▄   ║";
    public String ladroLine5 = "║ ▄██   °   °   ██▄  ║";
    public String ladroLine6 = "║ ███     A     ███  ║";
    public String ladroLine7 = "║ ███           ███  ║";
    public String ladroLine8 = "║  ██▄  ▀▀▀▀▀  ▄██   ║";
    public String ladroLine9 = "║   ▀██▄▄▄▄▄▄▄██▀    ║";
    public String ladroLine10 = "╟════════════════════╢";
}

class DisplayEroi {
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

    // 1° metodo del display personaggi, i nomi
    // metodo che accetta fino a un massimo di 20 caratteri
    public void displayCharactersNames() {
        System.out.println("╔════════════════════╗╔════════════════════╗╔════════════════════╗");
        System.out
                .println("║" + String.format("%20s", pg1.getName()) + "║║" + String.format("%20s", pg2.getName()) + "║║"
                        + String.format("%20s", pg3.getName()) + "║");

    }

    // 2° metodo del display personaggi, i riquadri dei personaggi
    // questo metodo printa in console i ritratti dei personaggi a prescindere di
    // quale classe si sceglie
    public void displayCharactersFromLists() {
        // ciclo hardcodato a 10 perchè sono 10 Stringhe per ogni personaggio
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    pg1.getPortrait().get(i) + pg2.getPortrait().get(i) + pg3.getPortrait().get(i));
        }
    }

    // metodo che mostra la vita dei personaggi
    public void displayStats() {
        System.out.println("╔════════════════════╗╔════════════════════╗╔════════════════════╗");
        System.out.println("║       " + pg1.getVita() + "/" + pg1.getVita() + "        ║║       " + pg2.getVita() + "/"
                + pg2.getVita() + "        ║║       " + pg3.getVita() + "/" + pg3.getVita() + "        ║");
        System.out.println("╚════════════════════╝╚════════════════════╝╚════════════════════╝");

    }
}
