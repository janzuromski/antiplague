import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        JButton newGame = new JButton("New Game");
        newGame.addActionListener(e -> {
            new DifficultyDialog();
            dispose();
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));
        JButton highScores = new JButton("High Scores");
        highScores.addActionListener(e -> {
            new RankingWindow();
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(180, 130);
        setTitle("CoronaVirus");
        setLayout(new FlowLayout());
        add(newGame);
        add(highScores);
        add(exit);
    }

}
class RankingWindow extends JDialog {
    RankingList list;
    public RankingWindow()  {
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(500, 600));
        list = new RankingList();
        add(new JScrollPane(list));
    }
}
