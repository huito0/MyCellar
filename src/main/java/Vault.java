import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Getter
@Setter
public class Vault {

    public static int r = new Random().nextInt(99) + 1;
    private static Map<String, List<String>> allJars = new HashMap<>();
    private static Map<String, String> copyAllJars = new HashMap<>();

    /**
     * Создание коллекции банок и солений к каждой банке
     **/
    public static Map<String, List<String>> generateArrayJars() {
        for (int i = 0; i < new Random().nextInt(PicklesName.SIZE) + 1; i++) {
            allJars.put(PicklesName.randomPicklesName().toString(), Jar.generateArrayVegetables());
        }
        return allJars;
    }

    /**
     * Взять банку по наклейке
     **/
    public static void getJar(String name) throws Exception {
        for (String i : allJars.keySet()) {
            if (allJars.containsKey(name)) {
                if (r <= 2) {
                    allJars.remove(name);
                    throw new Exception("Вы уронили банку " + name + " и она разбилась");
                } else {
                    System.out.println("Вы взяли: " + name);
                    allJars.remove(name);
                    System.out.println("Сейчас в погребе осталось: " + allJars);
                    break;
                }
            } else {
                throw new Exception(name + " отсутствует в погребе и вы не можете его взять");
            }
        }
    }

    /**
     * Положить банку в погреб
     **/
    public static void setJar(String picklesName, List<String> vegetables) throws Exception {
        copyAllJars.put(picklesName, vegetables.toString());
        if (r <= 1) {
            throw new Exception("Вы уронили банку и она разбилась");
        } else if (!allJars.containsKey(picklesName)) {
            allJars.put(picklesName, vegetables);
            System.out.println("Вы положили в погреб: " + copyAllJars);
        } else if (allJars.containsKey(picklesName)) {
            System.out.println(copyAllJars.keySet() + " уже есть в погребе, поместите, пожалуйста другую банку");
        }
    }

    /**
     * Содержимое погреба
     **/
    public static void showCountCellar() {
        System.out.println("В погребе сейчас: " + allJars.entrySet());
    }
}


