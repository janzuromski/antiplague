import javax.swing.*;
import java.awt.*;

public class NorthView extends JPanel {

    MyTimer timer;

    public NorthView(Virus virus, World world) {
        timer = new MyTimer(virus, world);
        setLayout(new FlowLayout());
        add(timer);
        setBackground(new Color(91, 147, 189));
    }
}
