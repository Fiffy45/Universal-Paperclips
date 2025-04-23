public class Projekte {
    // <editor-fold desc="Variablen">
    static double drahtVerbessern = 1;
    static double herstellerVerbessern = 1;
    static double preisVerbessereHersteller = 1000;
    static double verbessereUmVerbessereHersteller = 1.25;
    static double preisVerbessereDraht = 1000;
    static double verbessereUmVerbessereDraht = 1.25;
    static double preisVerbessereMarketing = 1000;
    static double verbessereUmVerbessereMarketing = 1;
    static double preisMehrVertrauen = 1000;
    static int preisHandelnAlgorithmisch = 10000;
    static int preisAutomatischerDrahtkaeufer = 1000;
    static float marketingEffekt = 0;       //Hilfsvariable, um den Effekt des Marketings zu verbessern
    static int preisSuperDuperHersteller = 5000;

    // </editor-fold>

    public static void verbessereHersteller() {
        if(Rechenressourcen.operationen >= preisVerbessereHersteller) {
            Rechenressourcen.operationen -= (int) preisVerbessereHersteller;
            herstellerVerbessern = verbessereUmVerbessereHersteller;
            preisVerbessereHersteller = preisVerbessereHersteller * 1.2;
            verbessereUmVerbessereHersteller += 0.25;
        }
        else {
            Fehler.fehlerOperationen();
        }
    }

    public static void verbessereDraht() {
        if(Rechenressourcen.operationen >= preisVerbessereDraht) {
            Rechenressourcen.operationen -= (int) preisVerbessereDraht;
            drahtVerbessern = verbessereUmVerbessereDraht;
            preisVerbessereDraht = preisVerbessereDraht * 1.2;
            verbessereUmVerbessereDraht += 0.25;
        }
        else {
            Fehler.fehlerOperationen();
        }
    }

    public static void verbessereMarketing() {
        if(Rechenressourcen.operationen >= preisVerbessereMarketing) {
            Rechenressourcen.operationen -= (int) preisVerbessereMarketing;
            preisVerbessereMarketing = preisVerbessereMarketing * 1.2;
            verbessereUmVerbessereMarketing += 0.25;
            marketingEffekt = (float) (Geschaeft.marketingLevel * Projekte.verbessereUmVerbessereMarketing);
        }
        else {
            Fehler.fehlerOperationen();
        }
    }

    public static void mehrVertrauen() {
        if(Rechenressourcen.operationen >= preisMehrVertrauen) {
            Rechenressourcen.operationen -= (int) preisMehrVertrauen;
            Rechenressourcen.vertrauen += 1;
            preisMehrVertrauen = preisMehrVertrauen * 1.2;
        }
        else {
            Fehler.fehlerOperationen();
        }
    }

    public static void automatischerDrahtkaeufer() {
        if(Rechenressourcen.operationen >= preisAutomatischerDrahtkaeufer) {
            Rechenressourcen.operationen -= preisAutomatischerDrahtkaeufer;
            GUI.mainPanel.add(GUI.anzeigeDrahtkaeuferAnAus);
            GUI.mainPanel.add(GUI.drahtKaufenAutomatisch);
            GUI.mainPanel.remove(GUI.automatischerDrahtkaeufer);
            GUI.mainPanel.add(GUI.superDuperHerstellerbutton);
        }
        else {
            Fehler.fehlerOperationen();
        }
    }

    public static void superDuperHersteller() {
        if(Rechenressourcen.operationen >= preisAutomatischerDrahtkaeufer) {
            Rechenressourcen.operationen -= preisSuperDuperHersteller;
            GUI.mainPanel.add(GUI.anzeigeSuperDuperHersteller);
            GUI.mainPanel.add(GUI.superDuperHersteller);
            GUI.mainPanel.add(GUI.anzeigeSuperDuperHerstellerPreis);
            GUI.mainPanel.remove(GUI.superDuperHerstellerbutton);
            GUI.mainPanel.add(GUI.algorithmischesHandeln);
        }
        else {
            Fehler.fehlerOperationen();
        }
    }

    public static void handelnAlgorithmisch() {
        if(Rechenressourcen.operationen >= preisHandelnAlgorithmisch) {
            Rechenressourcen.operationen -= preisHandelnAlgorithmisch;
            GUI.frame.add(GUI.topPanel);
            GUI.mainPanel.remove(GUI.algorithmischesHandeln);
        }
        else {
            Fehler.fehlerOperationen();
        }
    }
}
