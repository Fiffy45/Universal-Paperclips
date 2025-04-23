import javax.swing.*;
import java.awt.*;

public class GUI {
    //alle UI Elemente außerhalb von Überschriften
    // <editor-fold desc="Allgemein">
    public static JFrame frame;     //Fenster, in dem sich alles abspielt
    public static JPanel mainPanel;     //Ausschnitt in dem Fenster, wo alles aus Investitionen passiert
    private static JProgressBar progressBar;        //Fortschrittsbalken, wie lange es noch dauert, bis man gewonnen hat
    //Text
    public static JLabel anzeigeGesamtBueroklammern;        //Textfeld für gesamten Büroklammern
    //Buttons
    public static JButton bueroklammerHerstellen;       //Button, um Büroklammern per Knopfdruck herzustellen
    // </editor-fold>

    //alle UI Elemente unter der Überschrift Geschäft
    // <editor-fold desc="Geschäft">
    //Text
    public static JLabel anzeigeUeberschrift1;
    public static JLabel anzeigeBueroklammern;
    public static JLabel anzeigeBueroklammernPreis;
    public static JLabel anzeigeGeld;
    public static JLabel anzeigeMarketingLevel;
    public static JLabel anzeigeMarketingKosten;
    //Buttons
    public static JButton bueroklammerPreisErhoehen;
    public static JButton bueroklammerPreisVerringern;
    public static JButton marketingLevelErhoehen;
    // </editor-fold>

    //alle UI Elemente unter der Überschrift Herstellung
    // <editor-fold desc="Herstellung">
    //Text
    public static JLabel anzeigeUeberschrift2;
    public static JLabel anzeigeDrahtkaeuferAnAus;
    public static JLabel anzeigeDraht;
    public static JLabel anzeigeDrahtpreis;
    public static JLabel anzeigeAutomatischerHersteller;
    public static JLabel anzeigeAutomatischerHerstellerPreis;
    public static JLabel anzeigeSuperDuperHersteller;
    public static JLabel anzeigeSuperDuperHerstellerPreis;
    //Buttons
    public static JButton drahtKaufenAutomatisch;
    public static JButton drahtKaufen;
    public static JButton automatischenHerstellerKaufen;
    public static JButton superDuperHersteller;
    // </editor-fold>

    //alle UI Elemente unter der Überschrift Rechenressourcen
    // <editor-fold desc="Rechenressourcen">
    //Text
    public static JLabel anzeigeUeberschrift3;
    public static JLabel anzeigeVertrauen;
    public static JLabel anzeigeMehrVertrauen;
    public static JLabel anzeigeAnzahlProzessoren;
    public static JLabel anzeigeAnzahlSpeicher;
    public static JLabel anzeigeAnzahlOperationen;
    public static JLabel anzeigeAnzahlKreativitaet;
    //Buttons
    public static JButton anzahlProzessorenErhoehen;
    public static JButton anzahlSpeicherErhoehen;
    // </editor-fold>

    //alle UI Elemente unter der Überschrift Projekte
    // <editor-fold desc="Projekte">
    //Text
    public static JLabel anzeigeUeberschrift4;
    //Buttons
    public static JButton bessereHersteller25;
    public static JButton mehrDraht25;
    public static JButton besseresMarketing50;
    public static JButton vertrauen1Mehr;
    public static JButton algorithmischesHandeln;
    public static JButton automatischerDrahtkaeufer;
    public static JButton superDuperHerstellerbutton;
    // </editor-fold>

    //alle UI Elemente unter der Überschrift Investitionen
    //<editor-fold desc="Investitionen">
    public static JPanel topPanel;
    public static JComboBox<String> risikoAuswahl;
    public static JButton einzahlenButton, auszahlenButton, aktieKaufenButton, aktieVerkaufenButton;
    public static JLabel anzeigeUeberschrift5, anzeigeGeldNichtAktien, anzeigeGeldAktien, anzeigeGeldGesamt, anzeigeAktienname;
    public static GraphPanel graphpanelAmazon;
    public static GraphPanel graphpanelSiemens;
    public static GraphPanel graphpanelApple;
    // </editor-fold>

    //Deklaration von Farben
    //<editor-fold desc="Farben">
    public static Color gruen;
    public static Color grau;
    // </editor-fold>

    //Funktion, wo alle anderen Funktionen der GUI aufgerufen werden + Fortschrittsleiste + Fenster + Hauptpanel + Farben
    public static void ausfuehren() {
        frame = new JFrame("Universelle Büroklammern");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,870,750);
        //mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel.setLayout(null);


        gruen = new Color(34, 139, 34);
        grau = new Color(224, 224, 224);
        UIManager.put("ProgressBar.selectionForeground", Color.BLACK);          // Textfarbe
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);          // Hintergrund der Schrift

        progressBar = new JProgressBar(0, Main.wannGewonnen);
        progressBar.setBounds(500, 10, 360, 25);
        progressBar.setStringPainted(true);
        progressBar.setForeground(gruen);   // Farbe des Fortschritts
        progressBar.setBackground(grau); // Hintergrund
        progressBar.setBorderPainted(false);
        mainPanel.add(progressBar);

        frame.add(mainPanel);
        frame.setVisible(true);


        geschaeft();
        herstellung();
        rechenressourcen();
        projekte();
        investitionen();

    }

    //Funktion für alle UI Elemente unter der Überschrift Geschäft
    private static void geschaeft() {
        //Text
        anzeigeGesamtBueroklammern = new JLabel("<html><b><font size='5'>Büroklammern (gesamt):<br>" + Geschaeft.gesamtBueroklammern + "</font></b></html>");
        anzeigeGesamtBueroklammern.setBounds(50, 5, 350, 40);
        mainPanel.add(anzeigeGesamtBueroklammern);

        anzeigeUeberschrift1 = new JLabel("<html><b><font size='4'>Geschäft</font></b><hr width='300'></html>");
        anzeigeUeberschrift1.setBounds(50, 100, 150, 20);
        mainPanel.add(anzeigeUeberschrift1);

        anzeigeBueroklammern = new JLabel("Büroklammern: " + Geschaeft.bueroklammern);
        anzeigeBueroklammern.setBounds(50, 125, 150, 15);
        mainPanel.add(anzeigeBueroklammern);

        anzeigeBueroklammernPreis = new JLabel("Büroklammern Preis: " + String.format("%.2f", Geschaeft.bueroklammerPreis) + "€");
        anzeigeBueroklammernPreis.setBounds(50, 145, 170, 15);
        mainPanel.add(anzeigeBueroklammernPreis);

        anzeigeGeld = new JLabel("Geld: " + String.format("%.1f", Geschaeft.geld) + "€");
        anzeigeGeld.setBounds(50, 165, 150, 15);
        mainPanel.add(anzeigeGeld);

        anzeigeMarketingLevel = new JLabel("Marketinglevel: " + String.format("%.0f", Geschaeft.marketingLevel));
        anzeigeMarketingLevel.setBounds(50, 190, 150, 15);
        mainPanel.add(anzeigeMarketingLevel);

        anzeigeMarketingKosten = new JLabel("Marketingkosten: " + String.format("%.2f", Geschaeft.marketingKosten));
        anzeigeMarketingKosten.setBounds(50, 210, 150, 15);
        mainPanel.add(anzeigeMarketingKosten);

        //Buttons
        bueroklammerPreisErhoehen = new JButton("erhöhen");
        bueroklammerPreisErhoehen.setBounds(340, 145, 100, 20);
        mainPanel.add(bueroklammerPreisErhoehen);

        bueroklammerPreisVerringern = new JButton("verringern");
        bueroklammerPreisVerringern.setBounds(220, 145, 100, 20);
        mainPanel.add(bueroklammerPreisVerringern);

        marketingLevelErhoehen = new JButton("Marketing");
        marketingLevelErhoehen.setBounds(220, 195, 100, 20);
        mainPanel.add(marketingLevelErhoehen);
    }

    //Funktion für alle UI Elemente unter der Überschrift Herstellung
    private static void herstellung() {
        //Text
        anzeigeUeberschrift2 = new JLabel("<html><b><font size='4'>Herstellung</font></b><hr width='300'></html>");
        anzeigeUeberschrift2.setBounds(50, 250, 150, 20);
        mainPanel.add(anzeigeUeberschrift2);

        anzeigeDrahtkaeuferAnAus = new JLabel(Herstellung.drahtkaeuferAnAus);
        anzeigeDrahtkaeuferAnAus.setBounds(410, 280, 200, 20);

        anzeigeDraht = new JLabel("Draht: " + Herstellung.draht);
        anzeigeDraht.setBounds(50, 275, 150, 15);
        mainPanel.add(anzeigeDraht);

        anzeigeDrahtpreis = new JLabel("Drahtpreis: " + Herstellung.drahtpreis + "€");
        anzeigeDrahtpreis.setBounds(50, 295, 150, 15);
        mainPanel.add(anzeigeDrahtpreis);

        anzeigeAutomatischerHersteller = new JLabel("automatische Hersteller: " + Herstellung.anzahlAutomatischeHersteller);
        anzeigeAutomatischerHersteller.setBounds(50, 315, 155, 15);
        mainPanel.add(anzeigeAutomatischerHersteller);

        anzeigeAutomatischerHerstellerPreis = new JLabel("Preis: " + String.format("%.1f", Herstellung.preisAutomatischerHersteller) + "€");
        anzeigeAutomatischerHerstellerPreis.setBounds(50, 335, 150, 15);
        mainPanel.add(anzeigeAutomatischerHerstellerPreis);

        anzeigeSuperDuperHersteller = new JLabel("Super Duper Hersteller: " + Herstellung.anzahlSuperDuperHersteller);
        anzeigeSuperDuperHersteller.setBounds(50, 355, 150, 15);

        anzeigeSuperDuperHerstellerPreis = new JLabel("Preis: " + String.format("%.1f", Herstellung.preisSuperDuperHersteller) + "€");
        anzeigeSuperDuperHerstellerPreis.setBounds(50, 375, 150, 15);

        //Buttons
        bueroklammerHerstellen = new JButton("Büroklammer herstellen");
        bueroklammerHerstellen.setBounds(50, 50, 220, 30);
        mainPanel.add(bueroklammerHerstellen);

        drahtKaufenAutomatisch = new JButton("auto");
        drahtKaufenAutomatisch.setBounds(340, 280, 60, 20);

        drahtKaufen = new JButton("Draht");
        drahtKaufen.setBounds(220, 280, 100, 20);
        mainPanel.add(drahtKaufen);

        automatischenHerstellerKaufen = new JButton("automatischen Hersteller kaufen");
        automatischenHerstellerKaufen.setBounds(220, 320, 220, 20);
        mainPanel.add(automatischenHerstellerKaufen);

        superDuperHersteller = new JButton("Super Duper Hersteller");
        superDuperHersteller.setBounds(220, 350, 220, 20);
    }

    //Funktion für alle UI Elemente unter der Überschrift Rechenressourcen
    private static void rechenressourcen() {
        // Text
        anzeigeUeberschrift3 = new JLabel("<html><b><font size='4'>Rechenressourcen</font></b><hr width='280'></html>");
        anzeigeUeberschrift3.setBounds(500, 100, 300, 20);
        mainPanel.add(anzeigeUeberschrift3);

        anzeigeVertrauen = new JLabel("Vertrauen: " + Rechenressourcen.vertrauen);
        anzeigeVertrauen.setBounds(500, 125, 150, 20);
        mainPanel.add(anzeigeVertrauen);

        anzeigeMehrVertrauen = new JLabel("+1 Vertrauen bei: " + Rechenressourcen.mehrVehrtrauenBei + " Büroklammern");
        anzeigeMehrVertrauen.setBounds(500, 145, 250, 20);
        mainPanel.add(anzeigeMehrVertrauen);

        anzeigeAnzahlProzessoren = new JLabel("Prozessoren: " + Rechenressourcen.prozessoren);
        anzeigeAnzahlProzessoren.setBounds(500, 165, 150, 20);
        mainPanel.add(anzeigeAnzahlProzessoren);

        anzeigeAnzahlSpeicher = new JLabel("Speicher: " + Rechenressourcen.speicher);
        anzeigeAnzahlSpeicher.setBounds(500, 185, 150, 20);
        mainPanel.add(anzeigeAnzahlSpeicher);

        anzeigeAnzahlOperationen = new JLabel("Operationen: " + Rechenressourcen.operationen + "/" + Rechenressourcen.maxOperationen);
        anzeigeAnzahlOperationen.setBounds(500, 205, 150, 20);
        mainPanel.add(anzeigeAnzahlOperationen);

        anzeigeAnzahlKreativitaet = new JLabel("Kreativität: " + Rechenressourcen.kreativitaet);
        anzeigeAnzahlKreativitaet.setBounds(500, 225, 150, 20);
        mainPanel.add(anzeigeAnzahlKreativitaet);

        //Buttons
        anzahlProzessorenErhoehen = new JButton("Prozessoren");
        anzahlProzessorenErhoehen.setBounds(750, 165, 110, 20);
        mainPanel.add(anzahlProzessorenErhoehen);

        anzahlSpeicherErhoehen = new JButton("Speicher");
        anzahlSpeicherErhoehen.setBounds(750, 185, 110, 20);
        mainPanel.add(anzahlSpeicherErhoehen);
    }

    //Funktion für alle UI Elemente unter der Überschrift Projekte
    private static void projekte() {
        //Text
        anzeigeUeberschrift4 = new JLabel("<html><b><font size='4'>Projekte</font></b><hr width='340'></html>");
        anzeigeUeberschrift4.setBounds(500, 270, 300, 20);
        mainPanel.add(anzeigeUeberschrift4);

        //Buttons
        bessereHersteller25 = new JButton("<html>bessere automatische<br>Hersteller (25%)<br>Preis: " + String.format("%.0f", Projekte.preisVerbessereHersteller) + " Operationen</html>");
        bessereHersteller25.setBounds(500, 295, 200, 60);
        mainPanel.add(bessereHersteller25);

        mehrDraht25 = new JButton("<html>mehr Draht zum<br>gleichen Preis (25%)<br>Preis: " + String.format("%.0f", Projekte.preisVerbessereDraht) + " Operationen</html>");
        mehrDraht25.setBounds(500, 355, 200, 60);
        mainPanel.add(mehrDraht25);

        besseresMarketing50 = new JButton("<html>besseres<br>Marketing (25%)<br>Preis: " + String.format("%.0f", Projekte.preisVerbessereMarketing) + " Operationen</html>");
        besseresMarketing50.setBounds(500, 415, 200, 60);
        mainPanel.add(besseresMarketing50);

        vertrauen1Mehr = new JButton("<html>besserer Computer<br>(+1 Vertrauen)<br>Preis: " + String.format("%.0f", Projekte.preisMehrVertrauen) + " Operationen</html>");
        vertrauen1Mehr.setBounds(500, 475, 200, 60);
        mainPanel.add(vertrauen1Mehr);

        automatischerDrahtkaeufer = new JButton("<html>automatischer<br>Drahtkäufer<br>Preis: " + Projekte.preisAutomatischerDrahtkaeufer + " Operationen</html>");
        automatischerDrahtkaeufer.setBounds(500, 535, 200, 60);
        mainPanel.add(automatischerDrahtkaeufer);

        superDuperHerstellerbutton = new JButton("<html>Super Duper automatischer<br>Hersteller<br>Preis: " + Projekte.preisSuperDuperHersteller + " Operationen</html>");
        superDuperHerstellerbutton.setBounds(500, 535, 200, 60);

        algorithmischesHandeln = new JButton("<html>algorithmisches Handeln<br>(Investitionsplattform)<br>Preis: " + Projekte.preisHandelnAlgorithmisch + " Operationen</html>");
        algorithmischesHandeln.setBounds(500, 535, 200, 60);
    }

    //Funktion für alle UI Elemente unter der Überschrift Investitionen
    private static void investitionen() {
        topPanel = new JPanel();
        topPanel.setBounds(880,90,340,320);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        topPanel.setLayout(null);

        //Text
        anzeigeUeberschrift5 = new JLabel("<html><b><font size='4'>Investitionen</font></b><hr width='90'></html>");
        anzeigeUeberschrift5.setBounds(20,10,100,20);
        topPanel.add(anzeigeUeberschrift5);

        anzeigeGeldNichtAktien = new JLabel("<html><font size='3'>Geld: </font>" + Investitionen.geldNichtAktien + "</html>");
        anzeigeGeldNichtAktien.setBounds(120,50,100,11);
        topPanel.add(anzeigeGeldNichtAktien);

        anzeigeGeldAktien = new JLabel("<html><font size='3'>Aktien: </font>" + Investitionen.geldAktien + "</html>");
        anzeigeGeldAktien.setBounds(120,61,100,11);
        topPanel.add(anzeigeGeldAktien);

        anzeigeGeldGesamt = new JLabel("<html><font size='3'>Gesamt: </font>" + Investitionen.geldGesamt + "</html>");
        anzeigeGeldGesamt.setBounds(120,72,100,11);
        topPanel.add(anzeigeGeldGesamt);

        anzeigeAktienname = new JLabel("");     //wird in Investitionen gesetzt
        anzeigeAktienname.setBounds(240,30,100,15);
        topPanel.add(anzeigeAktienname);

        //Buttons
        risikoAuswahl = new JComboBox<>(new String[]{"Gering Risk", "Medium Risk", "Hoch Risk"});
        risikoAuswahl.setBounds(125,7,100,23);
        topPanel.add(risikoAuswahl);

        einzahlenButton = new JButton("<html><font size='3'>einzahlen</font></html>");
        einzahlenButton.setBounds(20,50,90,15);
        topPanel.add(einzahlenButton);

        auszahlenButton = new JButton("<html><font size='3'>auszahlen</font></html>");
        auszahlenButton.setBounds(20,70,90,15);
        topPanel.add(auszahlenButton);

        aktieKaufenButton = new JButton("<html><font size='3'>kaufen</font></html>");
        aktieKaufenButton.setBounds(240,50, 90,15);
        topPanel.add(aktieKaufenButton);

        aktieVerkaufenButton = new JButton("<html><font size='3'>verkaufen</font></html>");
        aktieVerkaufenButton.setBounds(240,70, 90,15);
        topPanel.add(aktieVerkaufenButton);


        graphpanelAmazon = new GraphPanel(Investitionen.aktienanfangswerteAmazon);
        graphpanelAmazon.setBounds(20,100,290,200);

        graphpanelSiemens = new GraphPanel(Investitionen.aktienanfangswerteSiemens);
        graphpanelSiemens.setBounds(20,100,290,200);

        graphpanelApple = new GraphPanel(Investitionen.aktienanfangswerteApple);
        graphpanelApple.setBounds(20,100,290,200);
    }

    //Funktion, was alles oft geupdatet werden muss von der UI
    public static void bildschirmUpdate() {
        anzeigeGesamtBueroklammern.setText("<html><b><font size='5'>Büroklammern (gesamt):<br>" + Geschaeft.gesamtBueroklammern + "</font></b></html>");

        //Geschäfft
        anzeigeBueroklammern.setText("Büroklammern: " + Geschaeft.bueroklammern);
        anzeigeBueroklammernPreis.setText("Büroklammern Preis: " + String.format("%.2f", Geschaeft.bueroklammerPreis) + "€");
        anzeigeGeld.setText("Geld: " + String.format("%.1f", Geschaeft.geld) + "€");
        anzeigeMarketingLevel.setText("Marketinglevel: " + String.format("%.0f", Geschaeft.marketingLevel));
        anzeigeMarketingKosten.setText("Marketingkosten: " + String.format("%.2f", Geschaeft.marketingKosten));

        //Herstellung
        anzeigeDraht.setText("Draht: " + Herstellung.draht);
        anzeigeDrahtpreis.setText("Drahtpreis: " + Herstellung.drahtpreis + "€");
        anzeigeAutomatischerHersteller.setText("automatische Hersteller: " + Herstellung.anzahlAutomatischeHersteller);
        anzeigeAutomatischerHerstellerPreis.setText("Preis: " + String.format("%.1f", Herstellung.preisAutomatischerHersteller) + "€");
        anzeigeDrahtkaeuferAnAus.setText(Herstellung.drahtkaeuferAnAus);
        anzeigeSuperDuperHersteller.setText("Super Duper Hersteller: " + Herstellung.anzahlSuperDuperHersteller);
        anzeigeSuperDuperHerstellerPreis.setText("Preis: " + String.format("%.1f", Herstellung.preisSuperDuperHersteller) + "€");

        //Rechenressourcen
        anzeigeVertrauen.setText("Vertrauen: " + Rechenressourcen.vertrauen);
        anzeigeMehrVertrauen.setText("+1 Vertrauen bei: " + Rechenressourcen.mehrVehrtrauenBei + " Büroklammern");
        anzeigeAnzahlProzessoren.setText("Prozessoren: " + Rechenressourcen.prozessoren);
        anzeigeAnzahlSpeicher.setText("Speicher: " + Rechenressourcen.speicher);
        anzeigeAnzahlOperationen.setText("Operationen: " + Rechenressourcen.operationen + "/" + Rechenressourcen.maxOperationen);
        anzeigeAnzahlKreativitaet.setText("Kreativität: " + Rechenressourcen.kreativitaet);

        //Projekte
        bessereHersteller25.setText("<html>bessere automatische<br>Hersteller (25%)<br>Preis: " + String.format("%.0f", Projekte.preisVerbessereHersteller) + " Operationen</html>");
        mehrDraht25.setText("<html>mehr Draht zum<br>gleichen Preis (25%)<br>Preis: " + String.format("%.0f", Projekte.preisVerbessereDraht) + " Operationen</html>");
        besseresMarketing50.setText("<html>besseres<br>Marketing (25%)<br>Preis: " + String.format("%.0f", Projekte.preisVerbessereMarketing) + " Operationen</html>");
        vertrauen1Mehr.setText("<html>besserer Computer<br>(+1 Vertrauen)<br>Preis: " + String.format("%.0f", Projekte.preisMehrVertrauen) + " Operationen</html>");

        //Investitionen
        anzeigeGeldNichtAktien.setText("<html><font size='3'>Geld: </font>" + Investitionen.geldNichtAktien + "</html>");
        anzeigeGeldAktien.setText("<html><font size='3'>Aktien: </font>" + Investitionen.geldAktien + "</html>");
        anzeigeGeldGesamt.setText("<html><font size='3'>Gesamt: </font>" + Investitionen.geldGesamt + "</html>");

        //Progress Bar
        progressBar.setValue((int) Geschaeft.geld);
        mainPanel.repaint();             //wichtig, dass Buttons und Text am Anfang direkt alles richtig angezeigt wird
        topPanel.repaint();
        topPanel.updateUI();
        frame.repaint();

    }
}