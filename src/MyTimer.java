import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MyTimer extends JPanel {

    public JLabel clock = new JLabel();
    private final Virus virus;
    private World world;
    private final JProgressBar progressBar = new JProgressBar();
    JLabel points = new JLabel("Points: 0");


    public MyTimer(Virus virus, World world) {
        this.virus = virus;
        this.world = world;
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setPreferredSize(new Dimension(300, 33));
        setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        clock.setMaximumSize(new Dimension(50, 33));
        progressBar.setToolTipText("Infection progress");
        progressBar.setForeground(Color.RED);
        progressBar.setMaximum((int) (world.getTotalPopulation() / 10));
        add(clock);
        add(progressBar);
        add(points);
    }

    public void feedProgressbar() {
        progressBar.setValue((int)(world.getTotalInfected() / 10));
        int percentage = (int) (((double) progressBar.getValue() / ((double) world.getTotalPopulation() / 10)) * 100);
        progressBar.setToolTipText("Infection progress: " + percentage + "%");
        points.setText("   Points: " + (int) world.getPoints());
    }
}
