package vlny;

import gui.NastalaChybaRamec;
import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Nepriatel;
import postavy.nepriatelia.Ork;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Číta vlny nepriateľov zo súboru.
 */
public class CitacVln {
    private final ArrayList<Vlna> nacitaneVlny;

    /**
     * Vytvorí inštanciu triedy CitacVln a načíta vlny zo zadaného súboru.
     * @param suborSVlnami Súbor obsahujúci dáta o vlnách.
     */
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

    /**
     * Vytvorí inštanciu nepriateľa na základe jeho názvu.
     * @param nazov Názov typu nepriateľa.
     * @return Inštancia triedy Nepriatel.
     * @throws RuntimeException Ak je zadaný neznámy typ nepriateľa.
     */
    private Nepriatel vytvorNepriatelazNazvu(String nazov) {
        return switch (nazov) {
            case "goblin" -> new Goblin();
            case "ork" -> new Ork();
            default -> throw new RuntimeException("Neznámy typ nepriateľa: " + nazov);
        };
    }

    /**
     * Vráti zoznam načítaných vĺn.
     * @return Zoznam inštancií triedy Vlna.
     */
    public ArrayList<Vlna> getNacitaneVlny() {
        return new ArrayList<>(this.nacitaneVlny);
    }
}