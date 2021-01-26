import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

class CountryInfo extends JPanel {
    MyText name, infected, population, percentageInfected, landArea, populationDensity, activeTransport;

    public CountryInfo(Country country) {
        setBackground(Color.WHITE);
        name = new MyText(country.getNAME());
        infected = new MyText("Infected: " + country.getPeopleInfected());
        population = new MyText("Population: " + country.getPOPULATION());
        percentageInfected = new MyText("% infected: 0%");
        landArea = new MyText("Land Area: " + country.getLANDAREA());
        populationDensity = new MyText("Population density: " + country.getPOPULATION_DENSITY());
        activeTransport = new MyText("Active transport: " + country.getActiveTransport());
        setPreferredSize(new Dimension(250, 220));
        setLayout(new GridLayout(7, 1));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        add(name);
        add(infected);
        add(population);
        add(percentageInfected);
        add(landArea);
        add(populationDensity);
        add(activeTransport);
    }

    public void setCountry(Country country) {
        int inf = (int)(((double) country.getPeopleInfected() / (double) country.getPOPULATION()) * 100);
        name.setText(country.getNAME());
        infected.setText("Infected: " + (int)country.getPeopleInfected());
        population.setText("Population: " + country.getPOPULATION());
        percentageInfected.setText("% infected: " + inf + "%");
        landArea.setText("Land Area: " + country.getLANDAREA());
        populationDensity.setText("Population density: " + country.getPOPULATION_DENSITY());
        activeTransport.setText("Active transport: " + country.getActiveTransport());
    }

    static class MyText extends JTextArea {
        public MyText(String text) {
            super(text);
            setEditable(false);
            setLineWrap(true);
            setMaximumSize(new Dimension(getWidth(), 100));
        }
    }
}
