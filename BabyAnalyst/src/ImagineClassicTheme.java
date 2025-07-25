import javax.swing.*;
import java.awt.*;

public class ImagineClassicTheme extends JPanel {
    private Image image;

    public ImagineClassicTheme() {
        image = new ImageIcon(getClass().getResource("/poze/statisticaFundalClassic.png")).getImage();
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
