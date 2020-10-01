import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Jar {
    public Vegetables[] vegetables = new Vegetables[Vegetables.SIZE];
    public PicklesName name;

    public Jar(PicklesName name, Vegetables[] vegetables) {
        this.name = name;
        this.vegetables = vegetables;
    }

    public Jar(PicklesName name) {
        this.name = name;
    }

    public Jar() {
    }

    /**
     * Генерируем рандомные коллекции с овощами, чтобы затем помещать их в банки
     **/
    public static List<String> generateArrayVegetables() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(Vegetables.SIZE); i++) {
            list.add(Vegetables.randomVegetable().toString());
        }
        return list;
    }
}
