public class Buttonsteuerung {
    //Funktion für den Aufruf der ganzen Buttonsteuerungsfunktionen
    public static void ausfuehren() {
        buttonGeschaeft();
        buttonHerstellung();
        buttonRechenressourcen();
        buttonProjekte();
        buttonInvestitionen();
    }

    //alle Buttons die zur Überschrift Geschäft gehören
    private static void buttonGeschaeft() {
        GUI.bueroklammerHerstellen.addActionListener(_ -> Geschaeft.bueroklammerHinzufuegen());     //Button "Büroklammer Herstellen": Büroklammer zur Anzeige hinzugefügen
        GUI.bueroklammerPreisErhoehen.addActionListener(_ -> Geschaeft.preisErhoehen());        //Button "erhöhen": Preis um 0.01 erhöhen
        GUI.bueroklammerPreisVerringern.addActionListener(_ -> Geschaeft.preisVerringern());        //Button "verringern": Preis um 0.01 verringern
        GUI.marketingLevelErhoehen.addActionListener(_ -> Geschaeft.marketing());       //Button "Marketing": Marketinglevel eins erhöhen und Preis abziehen
    }

    //alle Buttons die zur Überschrift Herstellung gehören
    private static void buttonHerstellung() {
        GUI.drahtKaufen.addActionListener(_ -> Herstellung.drahtHinzufuegen());     //Button "Draht": Draht hinzufügen und Geld abziehen
        GUI.automatischenHerstellerKaufen.addActionListener(_ -> Herstellung.kaufenAutomatischerHersteller());      //Button "automatischen Hersteller kaufen": einen hersteller hinzufügen und Geld abziehen
        GUI.drahtKaufenAutomatisch.addActionListener(_ -> Herstellung.automatischerDrahtkaeuferAnAus());
        GUI.superDuperHersteller.addActionListener(_ -> Herstellung.kaufenSuperDuperHersteller());
    }

    //alle Buttons die zur Überschrift Rechenressourcen gehören
    private static void buttonRechenressourcen() {
        GUI.anzahlProzessorenErhoehen.addActionListener(_ -> Rechenressourcen.prozessorenErhoehen());       //Button "Prozessoren": ein Prozessor hinzufügen
        GUI.anzahlSpeicherErhoehen.addActionListener(_ -> Rechenressourcen.speicherErhoehen());     //Button "Speicher": ein Speicher hinzufügen
    }

    //alle Buttons die zur Überschrift Projekte gehören
    private static void buttonProjekte() {
        GUI.bessereHersteller25.addActionListener(_ -> Projekte.verbessereHersteller());        //Button "bessere automatische Hersteller (25%)": automatische Hersteller verbessern
        GUI.mehrDraht25.addActionListener(_ -> Projekte.verbessereDraht());     //Button "mehr Draht zum gleichen Preis (25%)": Draht kaufen bringt mehr Draht als vorher
        GUI.besseresMarketing50.addActionListener(_ -> Projekte.verbessereMarketing());     //Button "besseres Marketing (25%)": Marketing wird besser gemacht
        GUI.vertrauen1Mehr.addActionListener(_ -> Projekte.mehrVertrauen());        //Button "besserer Computer (+1 Vertrauen)": 1 Vertrauen wird hinzugefügt
        GUI.algorithmischesHandeln.addActionListener(_ -> Projekte.handelnAlgorithmisch());     //Button "algorithmisches Handeln (Investitionsplattform)": schaltet Aktien frei
        GUI.automatischerDrahtkaeufer.addActionListener(_ -> Projekte.automatischerDrahtkaeufer());
        GUI.superDuperHerstellerbutton.addActionListener(_ -> Projekte.superDuperHersteller());

    }

    //alle Buttons die zur Überschrift Investitionen gehören
    private static void buttonInvestitionen() {
        GUI.risikoAuswahl.addActionListener(_ -> Investitionen.aktieNamensanzeige());       //aufklappbare Liste Risiko: Wahl des Risikos beim Investieren (also Auswahl der Aktie)
        GUI.einzahlenButton.addActionListener(_ -> Investitionen.einzahlen());      //Button "einzahlen": gesamtes Geld in das Aktienportal einzahlen
        GUI.auszahlenButton.addActionListener(_ -> Investitionen.auszahlen());      //Button "auszahlen": Geld, was nicht in Aktien investiert ist, auszahlen
        GUI.aktieKaufenButton.addActionListener(_ -> Investitionen.aktieKaufen());      //Button "kaufen": Alles, was im Portal ist, wird in Aktien investiert
        GUI.aktieVerkaufenButton.addActionListener(_ -> Investitionen.aktieVerkaufen());        //Button "verkaufen": alle Aktien werden verkauft
    }
}
