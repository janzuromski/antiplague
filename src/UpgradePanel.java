import javax.swing.*;
import java.awt.*;

public class UpgradePanel extends JPanel {
    UpgradeTile[] upgradeTiles;
    World world;
    Virus virus;


    public UpgradePanel(World world) {
        this.world = world;
        setBackground(new Color(91, 147, 189));
        setPreferredSize(new Dimension(1000, 110));
        upgradeLoad();
        for (int i = 0; i < 9; i++)
            add(upgradeTiles[i]);
    }

    private void upgradeLoad() {
        upgradeTiles = new UpgradeTile[9];
        upgradeTiles[0] = new UpgradeTile(
                new Upgrade("Transport I") {
                    @Override
                    public void upgrade() { Transport.decreaseVirality(0.5); }
                },
                "Lowers the infected people cut off point at which countries disable their transports by 30%."
        );
        upgradeTiles[1] = new UpgradeTile(
                new Upgrade("Transport II") {
                    @Override
                    public void upgrade() { Transport.decreaseVirality(0.5); }
                },
                "By appling hygiene measures, people are less likely to get infected while travelling"
        );
        upgradeTiles[2] = new UpgradeTile(
                new Upgrade("Transport III") {
                    @Override
                    public void upgrade() {
                        Transport.decreaseVirality(0.5);
                    }
                },
                "Frequent public transport disinfection"
        );
        upgradeTiles[3] = new UpgradeTile(
                new Upgrade("Distancing") {
                    @Override
                    public void upgrade() { Virus.decreaseIntensity(0.2); }
                },
                "Introducing Social Distancing decreases infection rate"
        );
        upgradeTiles[4] = new UpgradeTile(
                new Upgrade("Shutdown") {
                    @Override
                    public void upgrade() { Virus.decreaseIntensity(0.2); }
                },
                "Shutting down public spaces slows the pandemic down"
        );
        upgradeTiles[5] = new UpgradeTile(
                new Upgrade("Hygiene") {
                    @Override
                    public void upgrade() { Virus.decreaseIntensity(0.2); }
                },
                "People are subjecting to strict hygiene regime, infection rate drops."
        );
        upgradeTiles[6] = new UpgradeTile(
                new Upgrade("Testing") {
                    @Override
                    public void upgrade() {
                        Virus.decreaseIntensity(0.2);
                    }
                },
                "Testing and isolation"
        );
        upgradeTiles[7] = new UpgradeTile(
                new Upgrade("Borders") {
                    @Override
                    public void upgrade() {
                        Virus.decreaseIntensity(0.2);
                    }
                },
                "Countries restrict border-crossing transport"
        );
        upgradeTiles[8] = new UpgradeTile(
                new Upgrade("Quarantine") {
                    @Override
                    public void upgrade() {
                        Virus.decreaseIntensity(0.2);
                    }
                },
                "Introduction of long-term quarantine for infected people"
        );
    }
}
