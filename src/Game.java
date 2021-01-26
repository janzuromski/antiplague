import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game extends JFrame implements Runnable {

    Virus virus;
    World world;
    JLabel background = new JLabel(new ImageIcon("src/zdjecia/swiat.png"));
    JMenuBar menuBar = new JMenuBar();
    JMenu settings = new JMenu("Settings");
    JMenuItem quit = new JMenuItem("Quit");
    NorthView northView;
    private int duration = 240;

    public Game(Virus.Difficulty difficulty) {
        world = new World();
        virus = new Virus(difficulty);
        northView = new NorthView(virus, world);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1250, 920);
        setResizable(false);
        setLocationRelativeTo(null);
        add(background);
        quit.addActionListener(e -> {
            SwingUtilities.invokeLater(MainMenu::new);
            dispose();
        });
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                InputEvent.ALT_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
        settings.add(quit);
        menuBar.add(settings);
        setJMenuBar(menuBar);
        add(northView, BorderLayout.NORTH);
        add(new UpgradePanel(world), BorderLayout.SOUTH);
        add(new CountriesPanel(world.getCountries()), BorderLayout.WEST);
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(this);
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter++ < duration) {

            int minutes = (duration - counter) / 60;
            int seconds = (duration - counter) % 60;

            northView.timer.clock.setText(minutes + ":" + (seconds < 10 ? "0" + seconds : seconds) + "   ");
            world.addPoints();
            northView.timer.feedProgressbar();

            if (counter % 4 == 0) {
                virus.infect(world);
                if (world.getTotalInfected() / world.getTotalPopulation() > 0.98)
                    break;
            }

            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException ex) { ex.printStackTrace(); }
        }
        int points = (int) World.getTotalPoints();
        switch (virus.getDifficulty()) {
            case HIGH: points *= 5; break;
            case MEDIUM: points *= 2; break;
        }
        dispose();
        new RankingInputWindow(points, duration, virus.getDifficulty());
    }

    public static void start(Virus.Difficulty difficulty) {
        SwingUtilities.invokeLater(() -> new Game(difficulty));
    }



}
