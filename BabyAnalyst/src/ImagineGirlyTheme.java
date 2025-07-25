import javax.swing.*;
import java.awt.*;

public class ImagineGirlyTheme extends JPanel {
    private Image image;

    public ImagineGirlyTheme() {
        image = new ImageIcon(getClass().getResource("/poze/statisticaFundalGirly.png")).getImage();
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