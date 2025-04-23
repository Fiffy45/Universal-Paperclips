import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
    Color grau = new Color(238, 238, 238);
    private final ArrayList<Integer> werte;

    public static int minWert = 0;
    public static int maxWert = 100;

    public GraphPanel(int[] startwerte) {
        this.werte = new ArrayList<>();
        for (int w : startwerte) {
            werte.add(w);
        }
        setBackground(grau);
    }

    public void aktualisiereGraph(int neuerWert) {
        if (!werte.isEmpty()) {
            werte.removeFirst();
        }
        werte.add(neuerWert);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (werte.size() < 2) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int breite = getWidth();
        int hoehe = getHeight();

        int rand = 50;
        int achseLinks = rand;
        int achseUnten = hoehe - rand;

        // Achsen zeichnen
        g2.drawLine(achseLinks, rand, achseLinks, achseUnten);            // Y-Achse
        g2.drawLine(achseLinks, achseUnten, breite - rand, achseUnten);   // X-Achse

        // Einheitenbeschriftung
        g2.drawString("Wert", 10, rand - 10);
        g2.drawString("Zeit", breite - 40, hoehe - 30);

        // Max-Wert berechnen
        int max = werte.stream().max(Integer::compareTo).orElse(1);

        int abstandX = (breite - 2 * rand) / (werte.size() - 1);
        g2.setColor(Color.BLUE);

        // Graph zeichnen
        for (int i = 0; i < werte.size() - 1; i++) {
            int x1 = achseLinks + i * abstandX;
            int y1 = mapWertZuY(werte.get(i), hoehe, rand);
            int x2 = achseLinks + (i + 1) * abstandX;
            int y2 = mapWertZuY(werte.get(i + 1), hoehe, rand);

            g2.drawLine(x1, y1, x2, y2);
            g2.fillOval(x1 - 3, y1 - 3, 6, 6);
        }

        // Letzten Punkt zeichnen
        int lastX = achseLinks + (werte.size() - 1) * abstandX;
        int lastY = mapWertZuY(werte.get(werte.size() - 1), hoehe, rand);
        g2.fillOval(lastX - 3, lastY - 3, 6, 6);

        // X-Achse Zahlen
        g2.setColor(Color.BLACK);
        for (int i = 0; i < werte.size(); i++) {
            int x = achseLinks + i * abstandX;
            g2.drawLine(x, achseUnten - 5, x, achseUnten + 5);
            g2.drawString(String.valueOf(i), x - 5, achseUnten + 20);
        }

        // Y-Achse Zahlen
        int yTeilungen = 5;
        for (int i = 0; i <= yTeilungen; i++) {
            int y = achseUnten - i * (hoehe - 2 * rand) / yTeilungen;
            int wert = minWert + i * (maxWert - minWert) / yTeilungen;
            g2.drawLine(achseLinks - 5, y, achseLinks + 5, y);
            g2.drawString(String.valueOf(wert), achseLinks - 35, y + 5);
        }
    }
    // Hilfsmethode: Wert in y-Koordinate umrechnen
    private int mapWertZuY(int wert, int panelHoehe, int rand) {
        int achseUnten = panelHoehe - rand;
        int zeichenHoehe = panelHoehe - 2 * rand;
        double normiert = (double)(wert - minWert) / (maxWert - minWert);
        return achseUnten - (int)(normiert * zeichenHoehe);
    }
}