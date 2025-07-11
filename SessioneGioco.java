public class SessioneGioco {
    // mostra le classi con un menù e poi selezioni Membro#1, Membro#2 e Membro#3
    // inizia la run, un mostro alla volta, 3 vs 1
    // inizio con 3 mostri max
}

class DisplayEroi {
    CreatoreLadro creatorArciere = new CreatoreLadro();
    CreatoreMago creatoreMago = new CreatoreMago();
    CreatoreGuerriero creatoreGuerriero = new CreatoreGuerriero();
    Personaggio pg1 = creatorArciere.creaPersonaggio("Tim");
    Personaggio pg2 = creatoreMago.creaPersonaggio("Sam");
    Personaggio pg3 = creatoreGuerriero.creaPersonaggio("Rob");

    public void displayGuerriero() {
        System.out.println("╔════════════════════╗");
        System.out.println("║   ▄▄▄████████▄▄▄   ║");
        System.out.println("║  ▄██▄▄▄▄▄▄▄▄▄██▄   ║");
        System.out.println("║ ▄██║  *   *  ║██▄  ║");
        System.out.println("║ ███║    ║    ║███  ║");
        System.out.println("║ ███║  ▄▄║▄▄  ║███  ║");
        System.out.println("║ ███║▄▄▄▄▄▄▄▄▄║███  ║");
        System.out.println("║  ██▄▄▄▄▄▄▄▄▄▄▄██   ║");
        System.out.println("║   ▀████████████▀   ║");
        System.out.println("╚════════════════════╝");

    }

    public void displayLadro() {
        System.out.println("╔════════════════════╗");
        System.out.println("║    ▄▄▄▄▄▄▄▄▄▄▄     ║");
        System.out.println("║   ▄███████████▄    ║");
        System.out.println("║  ▄██▄       ▄██▄   ║");
        System.out.println("║ ▄██   °   °   ██▄  ║");
        System.out.println("║ ███     A     ███  ║");
        System.out.println("║ ███           ███  ║");
        System.out.println("║  ██▄  ▀▀▀▀▀  ▄██   ║");
        System.out.println("║   ▀██▄▄▄▄▄▄▄██▀    ║");
        System.out.println("╚════════════════════╝");
    }

    public void displayMago() {
        System.out.println("╔════════════════════╗");
        System.out.println("║     ▄███████▄▄     ║");
        System.out.println("║▄▄▄▄███████████▄▄▄▄▄║");
        System.out.println("║  ▄██▄       ▄██▄   ║");
        System.out.println("║ ▄██   *   *   ██▄  ║");
        System.out.println("║ ███     A     ███  ║");
        System.out.println("║ ███   ▄▀▀▀▄   ███  ║");
        System.out.println("║  ██▄  ▀▀▀▀▀  ▄██   ║");
        System.out.println("║   ▀██▄▄▄▄▄▄▄██▀    ║");
        System.out.println("╚════════════════════╝");
    }

    public void displayAllCharacters() {
        System.out.println("╔════════════════════╦════════════════════╦════════════════════╗");
        System.out.println("║        TIM         ║        SAM         ║        ROB         ║");
        System.out.println("╠════════════════════╬════════════════════╬════════════════════╣");
        System.out.println("║    ▄▄▄▄▄▄▄▄▄▄▄     ║     ▄███████▄▄     ║   ▄▄▄████████▄▄▄   ║");
        System.out.println("║   ▄███████████▄    ║▄▄▄▄███████████▄▄▄▄▄║  ▄██▄▄▄▄▄▄▄▄▄██▄   ║");
        System.out.println("║  ▄██▄       ▄██▄   ║  ▄██▄       ▄██▄   ║ ▄██║  *   *  ║██▄  ║");
        System.out.println("║ ▄██   °   °   ██▄  ║ ▄██   *   *   ██▄  ║ ███║    ║    ║███  ║");
        System.out.println("║ ███     A     ███  ║ ███     A     ███  ║ ███║  ▄▄║▄▄  ║███  ║");
        System.out.println("║ ███           ███  ║ ███   ▄▀▀▀▄   ███  ║ ███║▄▄▄▄▄▄▄▄▄║███  ║");
        System.out.println("║  ██▄  ▀▀▀▀▀  ▄██   ║  ██▄  ▀▀▀▀▀  ▄██   ║  ██▄▄▄▄▄▄▄▄▄▄▄██   ║");
        System.out.println("║   ▀██▄▄▄▄▄▄▄██▀    ║   ▀██▄▄▄▄▄▄▄██▀    ║   ▀████████████▀   ║");
        System.out.println("╚════════════════════╩════════════════════╩════════════════════╝");
    }

    public void displayStats() {
        System.out.println("╔════════════════════╦════════════════════╦════════════════════╗");
        System.out.println("║       " + pg1.getVita() + "/" + pg1.getVita() + "        ║       " + pg2.getVita() + "/"
                + pg2.getVita() + "        ║       " + pg3.getVita() + "/" + pg3.getVita() + "        ║");
        System.out.println("╚════════════════════╩════════════════════╩════════════════════╝");

    }

    public void displayAttacchiGuerriero() {
        System.out.println("╔═══════════════╦═══════════════╦═══════════════╦══════════════╗");
        System.out.println("║ 1. Spadata    ║ 2.Aura Blade  ║ 3. Boomerang  ║ 4. Indietro  ║");
        System.out.println("╚═══════════════╩═══════════════╩═══════════════╩══════════════╝");
    }

    public void displayAttacchiMago() {
        System.out.println("╔═══════════════╦═══════════════╦═══════════════╦══════════════╗");
        System.out.println("║ 1.Pugno di F. ║   2.Fulmine   ║ 3.Magic Mssl  ║ 4. Indietro  ║");
        System.out.println("╚═══════════════╩═══════════════╩═══════════════╩══════════════╝");
    }

    public void displayAttacchiLadro() {
        System.out.println("╔═══════════════╦═══════════════╦═══════════════╦══════════════╗");
        System.out.println("║ 1.Pugno di F. ║   2.Fulmine   ║ 3.Magic Mssl  ║ 4. Indietro  ║");
        System.out.println("╚═══════════════╩═══════════════╩═══════════════╩══════════════╝");
    }
}
