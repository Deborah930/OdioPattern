import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public interface Mostro {
    int attacco(ArrayList<Personaggio> squadra);

    String getName();

    int getDanno();

    int getVita();

    ArrayList<String> getPortrait();
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
    private int danno;
    private int vita;
    private ArrayList<String> portrait;
    private Random randomChoice = new Random();

    public MostroBase() {
        Mostri mostroRandom = Mostri.getMostroRandom();
        this.name = mostroRandom.getNome();
        this.danno = mostroRandom.getDanno();
        this.vita = mostroRandom.getVita();
        this.portrait = mostroRandom.getRitratto();

    }

    // deve fare un attacco a turno e deve printare l'attacco a seconda del mostro
    // richiamato verso uno o più personaggi della squadra
    public int attacco(ArrayList<Personaggio> squadra) {
        System.out.println("Il " + getName() + " attacca " + squadra.get(randomChoice.nextInt(squadra.size()))
                + " per il totale di " + getDanno());
        return getDanno();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDanno() {
        return danno;
    }

    @Override
    public int getVita() {
        return vita;
    }

    @Override
    public ArrayList<String> getPortrait() {
        return portrait;
    }

    // metodo factory che ritorna un mostro con un portrait casuale
    public static Mostro generazioneMostro() {
        return new MostroBase() {
        };
    }
}