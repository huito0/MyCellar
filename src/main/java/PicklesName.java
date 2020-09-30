import java.util.List;
import java.util.Random;

public enum PicklesName {
    ASSORTI,
    SALTCUCUMBER,
    LECHO,
    SALTBROCCOLI;

    private static final List<PicklesName> VALUES = List.of(values());
    public static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static PicklesName randomPicklesName() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
