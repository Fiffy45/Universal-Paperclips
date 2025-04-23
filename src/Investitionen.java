import java.util.Objects;

public class Investitionen {
    // <editor-fold desc="Allgemein">
    public static int geldNichtAktien = 0;
    public static int geldAktien = 0;
    public static int geldGesamt = 0;
    static int aktienanzahlAmazon = 0;
    static int aktienanzahlSiemens = 0;
    static int aktienanzahlApple = 0;
    public static String risikoAusgewaehlt;
    public static int aktuellerAktienwertAmazon = 30;
    public static int aktuellerAktienwertSiemens = 500;
    public static int aktuellerAktienwertApple = 5000;
    public static int[] aktienanfangswerteAmazon = {12, 15, 13, 23, 30, 25, 30};
    public static int[] aktienanfangswerteSiemens = {150, 200, 123, 290, 466, 165, 500};
    public static int[] aktienanfangswerteApple = {1500, 2505, 1903, 3600, 4908, 2650, 5000};

    // </editor-fold>

    public static void einzahlen() {
        geldNichtAktien += (int) Geschaeft.geld;
        Geschaeft.geld = 0;
    }

    public static void auszahlen() {
        Geschaeft.geld += geldNichtAktien;
        geldNichtAktien = 0;
    }

    public static void geldGesamtBerechnung() {
        geldGesamt = geldAktien + geldNichtAktien;
    }

    public static void aktieNamensanzeige() {
        Investitionen.risikoAusgewaehlt = (String) GUI.risikoAuswahl.getSelectedItem();
        if(Objects.equals(risikoAusgewaehlt, "Gering Risk")) {
            GUI.anzeigeAktienname.setText("Aktie: Amazon");
            GraphPanel.minWert = 10;
            GraphPanel.maxWert = 30;
            Zeitsteuerung.zeitAktienkursAnzeigeAmazon();
            GUI.topPanel.add(GUI.graphpanelAmazon);
            GUI.topPanel.remove(GUI.graphpanelSiemens);
            GUI.topPanel.remove(GUI.graphpanelApple);
        }
        if(Objects.equals(risikoAusgewaehlt, "Medium Risk")) {
            GUI.anzeigeAktienname.setText("Aktie: Siemens");
            GraphPanel.minWert = 100;
            GraphPanel.maxWert = 500;
            Zeitsteuerung.zeitAktienkursAnzeigeSiemens();
            GUI.topPanel.add(GUI.graphpanelSiemens);
            GUI.topPanel.remove(GUI.graphpanelAmazon);
            GUI.topPanel.remove(GUI.graphpanelApple);
        }
        if(Objects.equals(risikoAusgewaehlt, "Hoch Risk")) {
            GUI.anzeigeAktienname.setText("Aktie: Apple");
            GraphPanel.minWert = 1000;
            GraphPanel.maxWert = 5000;
            Zeitsteuerung.zeitAktienkursAnzeigeApple();
            GUI.topPanel.add(GUI.graphpanelApple);
            GUI.topPanel.remove(GUI.graphpanelSiemens);
            GUI.topPanel.remove(GUI.graphpanelAmazon);
        }
    }

    public static void aktienkursGraphAmazon() {
        aktuellerAktienwertAmazon = Main.zufallszahl(10, 30);
        GUI.graphpanelAmazon.aktualisiereGraph(aktuellerAktienwertAmazon);
        geldAktien = aktienanzahlAmazon * aktuellerAktienwertAmazon;
    }

    public static void aktienkursGraphSiemens() {
        aktuellerAktienwertSiemens = Main.zufallszahl(100, 500);
        GUI.graphpanelSiemens.aktualisiereGraph(aktuellerAktienwertSiemens);
        geldAktien = aktienanzahlSiemens * aktuellerAktienwertSiemens;
    }

    public static void aktienkursGraphApple() {
        aktuellerAktienwertApple = Main.zufallszahl(1000, 5000);
        GUI.graphpanelApple.aktualisiereGraph(aktuellerAktienwertApple);
        geldAktien = aktienanzahlApple * aktuellerAktienwertApple;
    }

    public static void aktieKaufen() {
        Investitionen.risikoAusgewaehlt = (String) GUI.risikoAuswahl.getSelectedItem();
        if(Objects.equals(risikoAusgewaehlt, "Gering Risk")) {
           amazonAktieKaufen();
        }
        if(Objects.equals(risikoAusgewaehlt, "Medium Risk")) {
            siemensAktieKaufen();
        }
        if(Objects.equals(risikoAusgewaehlt, "Hoch Risk")) {
           appleAktieKaufen();
        }
    }

    public static void aktieVerkaufen() {
        Investitionen.risikoAusgewaehlt = (String) GUI.risikoAuswahl.getSelectedItem();
        geldNichtAktien += geldAktien;
        aktienanzahlAmazon = 0;
        aktienanzahlSiemens = 0;
        aktienanzahlApple = 0;
        geldAktien = 0;
    }

    public static void amazonAktieKaufen() {
        aktienanzahlAmazon = geldNichtAktien / aktuellerAktienwertAmazon;
        geldAktien = aktienanzahlAmazon * aktuellerAktienwertAmazon;
        geldNichtAktien -= aktienanzahlAmazon * aktuellerAktienwertAmazon;
    }

    public static void siemensAktieKaufen() {
        aktienanzahlSiemens = geldNichtAktien / aktuellerAktienwertSiemens;
        geldAktien = aktienanzahlSiemens * aktuellerAktienwertSiemens;
        geldNichtAktien -= aktienanzahlSiemens * aktuellerAktienwertSiemens;
    }

    public static void appleAktieKaufen() {
        aktienanzahlApple = geldNichtAktien / aktuellerAktienwertApple;
        geldAktien = aktienanzahlApple * aktuellerAktienwertApple;
        geldNichtAktien -= aktienanzahlApple * aktuellerAktienwertApple;
    }
}
