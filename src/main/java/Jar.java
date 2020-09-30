import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Jar {
    public static Vegetables[] vegetables = new Vegetables[Vegetables.SIZE];
    public static PicklesName name;
    public static List<String> list = new ArrayList<>();

    public Jar(PicklesName name, Vegetables[] vegetables) {
        Jar.name = name;
        Jar.vegetables = vegetables;
    }

    public Jar(PicklesName name) {
        Jar.name = name;
    }

    public Jar() {
    }

    /**
     * Генерируем рандомные коллекции с овощами, чтобы затем помещать их в банки
     **/
    public static List<String> generateArrayVegetables() {
        for (int i = 0; i < new Random().nextInt(Vegetables.SIZE); i++) {
            list.add(Vegetables.randomVegetable().toString());
        }
        return list;
    }
}
