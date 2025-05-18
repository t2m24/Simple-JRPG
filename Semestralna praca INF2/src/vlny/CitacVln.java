package vlny;

import gui.NastalaChybaRamec;
import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Nepriatel;
import postavy.nepriatelia.Ork;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CitacVln {
    ArrayList<Vlna> nacitaneVlny;

    public CitacVln(File suborSVlnami) {
        this.nacitaneVlny = new ArrayList<>();
        int cisloNacitanejVlny = 1;
        try {
            Scanner sc = new Scanner(suborSVlnami);
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            while (sc.hasNext()) {
                Nepriatel nepriatel1 = this.vytvorNepriatelazNazvu(sc.next());
                Nepriatel nepriatel2 = this.vytvorNepriatelazNazvu(sc.next());
                Nepriatel nepriatel3 = this.vytvorNepriatelazNazvu(sc.next());
                Nepriatel nepriatel4 = this.vytvorNepriatelazNazvu(sc.next());
                Vlna vlna = new Vlna(cisloNacitanejVlny, nepriatel1, nepriatel2, nepriatel3, nepriatel4);
                cisloNacitanejVlny++;
                this.nacitaneVlny.add(vlna);
            }
            sc.close();
        } catch (Exception e) {
            new NastalaChybaRamec();
            throw new RuntimeException("Chyba pri čítaní súboru s vlnami.", e);
        }
    }

    private Nepriatel vytvorNepriatelazNazvu(String nazov) {
        return switch (nazov) {
            case "goblin" -> new Goblin();
            case "ork" -> new Ork();
            default -> {
                throw new RuntimeException("Neznámy typ nepriateľa: " + nazov);
            }
        };
    }

    public ArrayList<Vlna> getNacitaneVlny() {
        return new ArrayList<>(this.nacitaneVlny);
    }
}