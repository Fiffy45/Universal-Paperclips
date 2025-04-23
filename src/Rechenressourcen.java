public class Rechenressourcen {
    // <editor-fold desc="Variablen">
    static int vertrauen = 5;
    static int mehrVehrtrauenBei = 2500;
    static int prozessoren = 0;
    static int speicher = 0;
    static int operationen = 0;
    static int maxOperationen = 1000;
    static int kreativitaet = 0;
    // </editor-fold>

    public static void ausfuehren() {
        if(Geschaeft.gesamtBueroklammern >= mehrVehrtrauenBei) {
            vertrauen += 1;
            mehrVehrtrauenBei = mehrVehrtrauenBei * 2;
        }
    }

    public static void speicherErhoehen() {
        if(Rechenressourcen.speicher + Rechenressourcen.prozessoren < Rechenressourcen.vertrauen) {
            Rechenressourcen.speicher += 1;
            Rechenressourcen.maxOperationen = (int) (Rechenressourcen.maxOperationen * 1.2);
        }
        else {
            Fehler.fehlerVertrauen();
        }
    }

    public static void prozessorenErhoehen() {
        if(speicher + prozessoren < vertrauen) {
            prozessoren += 1;
        }
        else {
            Fehler.fehlerVertrauen();
        }
    }
}
