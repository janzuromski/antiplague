import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyDialog extends JDialog {
    JButton
        low = new JButton("LOW"),
        medium = new JButton("MEDIUM"),
        high = new JButton("HIGH");
    JLabel label = new JLabel("SELECT DIFFICULTY");

    public DifficultyDialog() {
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(150, 150);
        setLayout(new FlowLayout());
        low.addActionListener(new AL(Virus.Difficulty.LOW));
        medium.addActionListener(new AL(Virus.Difficulty.MEDIUM));
        high.addActionListener(new AL(Virus.Difficulty.HIGH));
        add(label);
        add(low);
        add(medium);
        add(high);
    }

    class AL implements ActionListener {
        private final Virus.Difficulty difficulty;

        @Override
        public void actionPerformed(ActionEvent e) {
            Game.start(difficulty);
            dispose();
        }

        public AL(Virus.Difficulty difficulty) {
            this.difficulty = difficulty;
        }
    }
}
