import javax.swing.*;
import java.awt.*;

public class RankingInputWindow extends JFrame {

    JTextField txt = new JTextField(30);
    JLabel label = new JLabel("Type in your name: ");
    JButton submit = new JButton("submit");

    public RankingInputWindow(int points, int time, Virus.Difficulty difficulty) {
        setVisible(true);
        setSize(400, 120);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        submit.addActionListener(e ->  {
            if (!txt.getText().equals("")) {
                Ranking.addPlayer(txt.getText(), points, time, difficulty);
                dispose();
                new MainMenu();
            } else JOptionPane.showMessageDialog(null, "Należy wpisać użytkownika",
                        "Brak imienia", JOptionPane.ERROR_MESSAGE);
        });
        add(label);
        add(txt);
        add(submit);
    }

}
