import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UpgradeTile extends JPanel {
    final Upgrade upgrade;
    static final ImageIcon ICON = new ImageIcon("src/zdjecia/upgrade_icon3.png");
    JLabel
            pic = new JLabel(),
            name = new JLabel();



    public UpgradeTile(Upgrade upgrade, String description) {
        this.upgrade = upgrade;
        setBorder(new BevelBorder(BevelBorder.RAISED));
        setBackground(new Color(91, 147, 189));
        setLayout(new FlowLayout());
        pic.setIcon(ICON);
        addMouseListener(new ML());
        setPreferredSize(new Dimension(100, 100));
        add(pic);
        name.setText(upgrade.getNAME());
        setToolTipText(description);
        add(name);
    }

    class ML implements MouseListener {

        boolean disabled = false;

        @Override
        public void mouseClicked(MouseEvent e) {
            setBackground(Color.WHITE);
            if (!disabled) {
                int option = JOptionPane.showConfirmDialog(null, "Do you want to buy this upgrade?\n" +
                        "Cost: " + Upgrade.getCost(), "Confirm purchase", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    if (!(World.getPoints() < Upgrade.getCost())) {
                        upgrade.upgrade();
                        World.removePoints(Upgrade.getCost());
                        Upgrade.increaseCost();
                        disabled = true;
                    } else JOptionPane.showMessageDialog(null, "Not enough points!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) { if (!disabled) setBackground(new Color(8, 75, 125)); }

        @Override
        public void mouseReleased(MouseEvent e) { if (!disabled) setBackground(new Color(91, 147, 189)); }

        @Override
        public void mouseEntered(MouseEvent e) { if (!disabled) setBackground(new Color(8, 75, 125)); }

        @Override
        public void mouseExited(MouseEvent e) { if (!disabled) setBackground(new Color(91, 147, 189)); }
    }
}
