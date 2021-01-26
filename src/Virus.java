public class Virus {

    enum Difficulty {
        LOW, MEDIUM, HIGH
    }

    private static double infectionFactor;
    private Difficulty difficulty;

    public Virus(Difficulty difficulty) {
        this.difficulty = difficulty;
        switch (difficulty) {
            case LOW: infectionFactor = 0.01; break;
            case MEDIUM: infectionFactor = 0.02; break;
            case HIGH: infectionFactor = 0.03; break;
        }
    }

    public void infect(World world) {
        world.infect();
    }

    public static void decreaseIntensity(double percentage) { infectionFactor *= 1 - percentage; }

    public static double getInfectionFactor() { return infectionFactor; }

    public Difficulty getDifficulty() { return difficulty; }
}
