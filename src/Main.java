import javax.swing.*;       //für die anzeige "Gewonnen" im extra Fenster
import java.util.Random;        //für die Random-Klasse notwendig

public class Main {
    // <editor-fold desc="Variablen">
    static int wannGewonnen = 1000000;        //wie viel Geld erreicht werden muss, um zu gewinnen
    // </editor-fold>

    //main wird ausgeführt
    public static void main(String[] args) {
        GUI.ausfuehren();       //Grafische Oberflächge wird angezeigt

        Buttonsteuerung.ausfuehren();       //bringt actionen, wenn auf einen Button gedrückt wird.

        Zeitsteuerung.ausfuehren();     //versch. zeitabhängige Funktionen, die alle bestimmte Zeit, z.B. 5000ms aufgerufen werden
    }

    //wann gewonnen, mit Anzeige auf extra Fenster
    public static void gewonnen() {
        if(Geschaeft.geld >= wannGewonnen) {
            JOptionPane.showMessageDialog(null, "Glückwunsch! Sie haben das Spiel gewonnen!", "Spiel beendet", JOptionPane.INFORMATION_MESSAGE);        //Extra Fenster mit der textanzeige, dass man gewonnen hat
            System.exit(0);     //beendet das Programm
        }
    }

    //erstellt eine Zufallszahl, in den Grenzen angegebenen Grenzen
    public static int zufallszahl(int min, int max) {
        Random random = new Random();       //Random Klasse einbinden
        return random.nextInt(max - min + 1) + min;     //zahl zwischen Grenzen zurückgeben
    }
}