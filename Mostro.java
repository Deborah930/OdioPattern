import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public interface Mostro {
    int attacco(ArrayList<Personaggio> squadra);

    String getName();

    int getDanno();

    int getVita();

    void setVita(int danno);

    ArrayList<String> getPortrait();

    void displayMostroPortrait();
}

enum Mostri {
    DRAGO("Draghetto", 3, 20,
            new ArrayList<>(Arrays.asList(
                    "",
                    "           /\\   /\\",
                    "          (  . .)  ",
                    "           )   (   ",
                    "          (  v  )  ",
                    "        ^^^ \\_/ ^^^",
                    "       /           \\",
                    "      <  FIRE FIRE  >",
                    "       \\___________/"))),

    GOBLIN("Goblin Malvagio", 1, 15,
            new ArrayList<>(Arrays.asList(
                    "        /\\   /\\",
                    "       (  o o  )",
                    "        \\  ^  /",
                    "         \\___/",
                    "          | |",
                    "         /| |\\",
                    "        / | | \\",
                    "       (__| |__)"))),

    SCHELETRO("Scheletro Guerriero", 1, 18,
            new ArrayList<>(Arrays.asList(
                    "        _______      ",
                    "       /       \\",
                    "      | () ()    |",
                    "       \\ A   / /",
                    "        ||||| |",
                    "        |_____|",
                    "          |||",
                    "        /|   |\\"))),

    ORCO("Orco Brutale", 2, 25,
            new ArrayList<>(Arrays.asList(
                    "      ___________",
                    "     /           \\",
                    "    | (@@)   (@@) |",
                    "    |      ^      |",
                    "    |   \\     /   |",
                    "    |    \\___/    |",
                    "     \\___________/",
                    "          |||"))),

    STREGA("Strega Oscura", 3, 21,
            new ArrayList<>(Arrays.asList(
                    "        /\\",
                    "       /  \\",
                    "      | ** |",
                    "       \\__/",
                    "        ||",
                    "       /||\\",
                    "      / || \\",
                    "     /__||__\\")));

    private final String nome;
    private final int vita;
    private final int danno;
    private final ArrayList<String> ritratto;

    Mostri(String nome, int danno, int vita, ArrayList<String> ritratto) {
        this.nome = nome;
        this.danno = danno;
        this.vita = vita;
        this.ritratto = ritratto;
    }

    public String getNome() {
        return nome;
    }

    public int getDanno() {
        return danno;
    }

    public int getVita() {
        return vita;
    }

    public ArrayList<String> getRitratto() {
        return ritratto;
    }

    public static Mostri getMostroRandom() {
        Random random = new Random();
        Mostri[] mostri = values();
        return mostri[random.nextInt(mostri.length)];
    }
}

class MostroBase implements Mostro {
    private String name;
    private int dannoMostro;
    private int vita;
    private ArrayList<String> portrait;
    private Random randomChoice = new Random();

    // il costruttore sfrutta il metodo statico factory Mostri.getMostroRandom() per
    // ottenere e copiare i valori di un mostro in modo da instanziarlo poi nel
    // combattimento a turni
    public MostroBase() {
        Mostri mostroRandom = Mostri.getMostroRandom();
        this.name = mostroRandom.getNome();
        this.dannoMostro = mostroRandom.getDanno();
        this.vita = mostroRandom.getVita();
        this.portrait = mostroRandom.getRitratto();

    }

    // deve fare un attacco a turno e deve printare l'attacco a seconda del mostro
    // richiamato verso uno o più personaggi della squadra
    public int attacco(ArrayList<Personaggio> squadra) {
        int sceltaPgAttaccato = randomChoice.nextInt(squadra.size());
        Personaggio pgAttaccato = squadra.get(sceltaPgAttaccato);
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("Il " + getName() + " attacca " + pgAttaccato + " per " + getDanno() + " danni");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        return getDanno();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDanno() {
        return dannoMostro;
    }

    @Override
    public int getVita() {
        return vita;
    }

    @Override
    public void setVita(int danno) {
        this.vita -= danno;
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("Il " + getName() + " riceve " + danno + " danni!");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

    }

    @Override
    public ArrayList<String> getPortrait() {
        return portrait;
    }

    @Override
    public void displayMostroPortrait() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");

        for (String string : portrait) {
            // Calcola gli spazi necessari per centrare la stringa
            int totalSpaces = 21;
            int stringLength = string.length();
            int spacesNeeded = totalSpaces - stringLength;
            int leftSpaces = spacesNeeded / 2;
            int rightSpaces = spacesNeeded - leftSpaces;

            // Crea la stringa centrata
            String leftPadding = " ".repeat(leftSpaces);
            String rightPadding = " ".repeat(rightSpaces);
            String centeredString = leftPadding + string + rightPadding;

            System.out.println("║                 " + centeredString + "                 ║");
        }

        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    // metodo factory che ritorna un mostro con un portrait casuale
    public static Mostro generazioneMostro() {
        return new MostroBase() {
        };
    }
}