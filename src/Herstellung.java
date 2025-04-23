public class Herstellung {
    // <editor-fold desc="Variablen">
    static int draht = 10;
    static int drahtpreis = 15;
    static int anzahlAutomatischeHersteller = 0;
    static double preisAutomatischerHersteller = 5;
    static String drahtkaeuferAnAus = "AUS";
    static int anzahlSuperDuperHersteller = 0;
    static double preisSuperDuperHersteller = 100;
    // </editor-fold>

    public static void drahtHinzufuegen() {
        if(Geschaeft.geld >= drahtpreis) {
            draht += (int) (1000 * Projekte.drahtVerbessern);
            Geschaeft.geld -= drahtpreis;
        }
        else {
            Fehler.fehlerGeld();
        }
    }

    public static void kaufenAutomatischerHersteller() {
        if(Geschaeft.geld >= preisAutomatischerHersteller){
            anzahlAutomatischeHersteller += 1;
            Geschaeft.geld -= preisAutomatischerHersteller;
            preisAutomatischerHersteller = preisAutomatischerHersteller * 1.1;
        }
        else {
            Fehler.fehlerGeld();
        }
    }

    public static void automatischerDrahtkaeuferAnAus() {
        if(drahtkaeuferAnAus.equals("AUS")) {
            drahtkaeuferAnAus = "AN";
        }
        else {
            drahtkaeuferAnAus = "AUS";
        }
    }

    public static void automatischerDrahtkaeufer() {
        if(draht <= anzahlAutomatischeHersteller && drahtkaeuferAnAus.equals("AN")) {
            drahtHinzufuegen();
        }
    }

    public static void kaufenSuperDuperHersteller() {
        if(Geschaeft.geld >= preisSuperDuperHersteller){
            anzahlSuperDuperHersteller += 1;
            Geschaeft.geld -= preisSuperDuperHersteller;
            preisSuperDuperHersteller = preisSuperDuperHersteller * 1.1;
        }
        else {
            Fehler.fehlerGeld();
        }
    }
}
