import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CountriesPanel extends JPanel {
    CountriesList countriesList;
    CountryInfo countryInfo;

    public CountriesPanel(List<Country> countries) {
        countriesList = new CountriesList(countries);
        countryInfo = new CountryInfo(countries.get(36));
        countriesList.addListSelectionListener(e ->
                countryInfo.setCountry(((CountriesList)e.getSource()).getSelectedValue()));
        setLayout(new BorderLayout());
        add(new JScrollPane(countriesList), BorderLayout.CENTER);
        add(countryInfo, BorderLayout.SOUTH);
    }
}
