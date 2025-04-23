public class Geschaeft {
    // <editor-fold desc="Variablen">
    static long gesamtBueroklammern = 0L;     // Anzeige der Büroklammern, die man über die gesamte Zeit hergestellt hat
    static int bueroklammern = 0;       //Anzeige der Büroklammern, die man gerade hat und verkauft werden können
    static double bueroklammerPreis = 0.10;     //Anzeige, zu welchem Preis die Büroklammern verkauft werden
    static double geld = 1000;      //Anzeige, wie viel Geld man hat
    static float marketingLevel = 1;        //Anzeige auf welchem Level das Marketing ist
    static float marketingKosten = 100;     //Anzeige, wie viel das nächste Marketinglevel kostet
    // </editor-fold>

    //Funktion, um Büroklammern herzustellen
    public static void bueroklammerHinzufuegen() {
        if(Herstellung.draht > 0) {     //Wenn man über 0 Draht hat, dann wird eine Büroklammer hergestellt und zu gesamte und zum Verkauf stehende Büroklammer hinzugefügt + 1 Draht abgezogen
            bueroklammern += 1;
            gesamtBueroklammern += 1;
            Herstellung.draht -= 1;
        }
        else {
            Fehler.fehlerDraht();       //zu wenig Draht vorhanden
        }
    }

    //Funktion, die den Verkaufspreis um 0.01 erhöht
    public static void preisErhoehen() {
        Geschaeft.bueroklammerPreis += 0.01;
    }


    //Funktion, die den Verkaufspreis um 0.01 Verringert, solange der Preis größer 0 ist
    public static void preisVerringern()
    {
        if(Geschaeft.bueroklammerPreis > 0.02) {        //0.02, weil MYSTERIUM
            Geschaeft.bueroklammerPreis -= 0.01;
        }
    }

    //Funktion, die die Verkaufszahlen beeinflusst, wenn sich der Preis verändert
    public static void verkaufen() {
        double nachfrage = Math.pow(Geschaeft.bueroklammerPreis + (0.67 - Projekte.marketingEffekt / 50), -9) + (0.33 + Projekte.marketingEffekt); //Funktion Nachfrage der Büroklammern
        int verkaufsAnzahl = (int) Math.round(Math.min(nachfrage, Geschaeft.bueroklammern));        //Math.min wählt die kleinere Zahl von beiden aus
        Geschaeft.bueroklammern -= verkaufsAnzahl;
        Geschaeft.geld += verkaufsAnzahl * Geschaeft.bueroklammerPreis;
    }

    //Funktion, die das Marketinglevel erhöht und das Geld dafür abzieht
    public static void marketing() {
        if(geld - marketingKosten >= 0) {
            geld -= marketingKosten;
            marketingKosten = (float) (marketingKosten * 1.2);      //erhöhung der Marketingkosten, nachdem es gekauft wurde
            marketingLevel += 1;
            Projekte.marketingEffekt = (float) (Geschaeft.marketingLevel * Projekte.verbessereUmVerbessereMarketing);
        }
        else {
            Fehler.fehlerGeld();        //zu wenig geld
        }
    }
}
