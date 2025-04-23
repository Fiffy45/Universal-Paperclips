import javax.swing.*;       //für die Erstellung der extra Fenster notwendig

public class Fehler {
    //aufgerufen bei zu wenig Geld
    public static void fehlerGeld() {
        JOptionPane.showMessageDialog(null, "Nicht genug Geld!", "Fehler", JOptionPane.ERROR_MESSAGE);      //extra Fenster mit dem vorgegebenen Text, mit OK Button
    }

    //aufgerufen bei zu wenig Draht
    public static void fehlerDraht() {
        JOptionPane.showMessageDialog(null, "Nicht genug Draht!", "Fehler", JOptionPane.ERROR_MESSAGE);     //extra Fenster mit dem vorgegebenen Text, mit OK Button
    }

    //aufgerufen bei zu wenig Vertrauen
    public static void fehlerVertrauen() {
        JOptionPane.showMessageDialog(null, "Nicht genug Vertrauen!", "Fehler", JOptionPane.ERROR_MESSAGE);     //extra Fenster mit dem vorgegebenen Text, mit OK Button
    }

    //aufgerufen bei zu wenig Operationen
    public static void fehlerOperationen() {
        JOptionPane.showMessageDialog(null, "Nicht genug Operationen!", "Fehler", JOptionPane.ERROR_MESSAGE);       //extra Fenster mit dem vorgegebenen Text, mit OK Button
    }
}
