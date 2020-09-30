import java.util.List;
import java.util.Random;

public enum Vegetables {
    CUCUMBER,
    TOMATO,
    BROCCOLI,
    POTATO,
    PEPPER;

    private static final List<Vegetables> VALUES = List.of(values());
    public static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Vegetables randomVegetable() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
