import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.util.List;

public class CountriesList extends JList<Country> {

    public CountriesList(List<Country> countries) {
        super();
        setCellRenderer(new Cell());
        setModel(new Model(countries));
        setBackground(new Color(91, 147, 189));
    }

}

class Cell extends JLabel implements ListCellRenderer<Country> {

    @Override
    public Component getListCellRendererComponent(JList list, Country value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getNAME());
        return this;
    }
}

class Model implements ListModel<Country> {
    List<Country> countries;

    public Model(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public int getSize() {
        return countries.size();
    }

    @Override
    public Country getElementAt(int index) {
        return countries.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}

