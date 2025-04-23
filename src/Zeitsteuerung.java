import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zeitsteuerung {
    // <editor-fold desc="Variablen">
    public static Timer timerOperationenHinzufuegen;
    public static Timer timerAktienkursAnzeigeAmazon;
    public static Timer timerAktienkursAnzeigeSiemens;
    public static Timer timerAktienkursAnzeigeApple;
    // </editor-fold>

    public static void ausfuehren() {
        zeitKreativitaet();
        zeitOperationen();
        zeitVerkaufen();
        zeitAnzeigeDrahtpreis();
        zeitAutomatischerHersteller();
        zeitBildschirmUpdate();
        zeitOeftersPruefen();
        zeitSuperDuperHersteller();
    }

    private static void zeitKreativitaet() {
        Timer timerKreativitaetHinzufuegen = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Rechenressourcen.operationen == Rechenressourcen.maxOperationen) {
                    Rechenressourcen.kreativitaet += 1;
                }
            }
        });
        timerKreativitaetHinzufuegen.start();
    }

    public static void zeitOperationen() {
        timerOperationenHinzufuegen = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Rechenressourcen.operationen < Rechenressourcen.maxOperationen) {
                    Rechenressourcen.operationen += Rechenressourcen.prozessoren;
                }
            }
        });
        timerOperationenHinzufuegen.start();
    }

    private static void zeitVerkaufen() {
        Timer timerVerkaufen = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Geschaeft.verkaufen();
            }
        });
        timerVerkaufen.start();
    }

    private static void zeitAnzeigeDrahtpreis() {
        Timer timerDrahtpreis = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Herstellung.drahtpreis = Main.zufallszahl(10, 25);
            }
        });
        timerDrahtpreis.start();
    }

    private static void zeitAutomatischerHersteller() {
        Timer timerAutomatischerHersteller = new Timer((500), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Herstellung.draht - (1 * Herstellung.anzahlAutomatischeHersteller * Projekte.herstellerVerbessern) >= 0) {
                    Geschaeft.bueroklammern += (int) (1 * Herstellung.anzahlAutomatischeHersteller * Projekte.herstellerVerbessern);
                    Geschaeft.gesamtBueroklammern += (int) (1 * Herstellung.anzahlAutomatischeHersteller * Projekte.herstellerVerbessern);
                    Herstellung.draht -= (int) (1 * Herstellung.anzahlAutomatischeHersteller * Projekte.herstellerVerbessern);
                }
            }
        });
        timerAutomatischerHersteller.start();
    }

    private static void zeitSuperDuperHersteller() {
        Timer timerSuperDuperHersteller = new Timer((500), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Herstellung.draht - (5 * Herstellung.anzahlSuperDuperHersteller) >= 0) {
                    Geschaeft.bueroklammern += (5 * Herstellung.anzahlSuperDuperHersteller);
                    Geschaeft.gesamtBueroklammern += (5L * Herstellung.anzahlSuperDuperHersteller);
                    Herstellung.draht -= (5 * Herstellung.anzahlSuperDuperHersteller);
                }
            }
        });
        timerSuperDuperHersteller.start();
    }

    public static void zeitAktienkursAnzeigeAmazon() {
        timerAktienkursAnzeigeAmazon = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Investitionen.aktienkursGraphAmazon();
            }
        });
        timerAktienkursAnzeigeAmazon.start();
        if(timerAktienkursAnzeigeSiemens != null) {
            timerAktienkursAnzeigeSiemens.stop();
        }
        if(timerAktienkursAnzeigeApple != null) {
            timerAktienkursAnzeigeApple.stop();
        }
    }

    public static void zeitAktienkursAnzeigeSiemens() {
        timerAktienkursAnzeigeSiemens = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Investitionen.aktienkursGraphSiemens();
            }
        });
        timerAktienkursAnzeigeSiemens.start();
        if(timerAktienkursAnzeigeAmazon != null) {
            timerAktienkursAnzeigeAmazon.stop();
        }
        if(timerAktienkursAnzeigeApple != null) {
            timerAktienkursAnzeigeApple.stop();
        }
    }

    public static void zeitAktienkursAnzeigeApple() {
        timerAktienkursAnzeigeApple = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Investitionen.aktienkursGraphApple();
            }
        });
        timerAktienkursAnzeigeApple.start();
        if(timerAktienkursAnzeigeAmazon != null) {
            timerAktienkursAnzeigeAmazon.stop();
        }
        if(timerAktienkursAnzeigeSiemens != null) {
            timerAktienkursAnzeigeSiemens.stop();
        }
    }

    private static void zeitBildschirmUpdate() {
        Timer timerBildschirmUpdate = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.bildschirmUpdate();
            }
        });
        timerBildschirmUpdate.start();
    }

    private static void zeitOeftersPruefen() {
        Timer timerOeftersPruefen = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rechenressourcen.ausfuehren();
                Main.gewonnen();
                Investitionen.geldGesamtBerechnung();
                Herstellung.automatischerDrahtkaeufer();
            }
        });
        timerOeftersPruefen.start();
    }
}
