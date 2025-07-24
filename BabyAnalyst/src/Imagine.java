import javax.swing.*;
import java.awt.*;

public class Imagine extends JPanel {
    private Image image;

    public Imagine() {
        image = new ImageIcon(getClass().getResource("/poze/statisticaFundal.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 110, 0, 300, 540, this);
        } else {
            System.out.println("Imaginea nu a fost încărcată!");
        }
    }
}
