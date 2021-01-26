import java.io.*;
import java.util.*;

public class World {
    private final List<Country> countries;
    private long totalPopulation;
    private double totalInfected;
    private static double points;
    private static double totalPoints;

    public World() {
        points = 1.0;
        totalPoints = points;
        countries = new ArrayList<>();
        totalPopulation = 0;
        totalInfected = 0;
        countriesReader();
    }

    private void countriesReader() {
        ObjectInputStream in;
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/countries");
            in = new ObjectInputStream(fis);
            try {
                while (true) {
                    Country country = (Country) in.readObject();
                    totalPopulation += country.getPOPULATION();
                    countries.add(country);
                }
            } catch (EOFException ignored) {}
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void infect() {
        for (Country c : countries)
            totalInfected += c.infect();
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void addPoints() { points += 0.3; }

    public static void removePoints(int howMany) { points -= howMany; }

    public long getTotalPopulation() {
        return totalPopulation;
    }

    public double getTotalInfected() {
        return totalInfected;
    }

    public static double getPoints() { return points; }

    public static double getTotalPoints() { return totalPoints; }
}
