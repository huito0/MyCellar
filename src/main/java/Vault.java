import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Vault {

    private static Map<String, List<String>> allJars = new HashMap<>();
    private static Map<String, String> copyAllJars = new HashMap<>();
    public static int r = new Random().nextInt(99) + 1;

    /**
     * Создание коллекции банок и солений к каждой банке
     **/
    public static Map<String, List<String>> generateArrayJars() {
        allJars.put(PicklesName.randomPicklesName().toString(), Jar.generateArrayVegetables());
        List<String> list1 = allJars.values().stream().flatMap(List::stream).collect(Collectors.toList());
        for (int i = 0; i < list1.size(); i++) {
            if ((i + 1) % 2 == 0) {
                allJars.put(PicklesName.randomPicklesName().toString(), list1.subList(0,i));
            } else {
                allJars.put(PicklesName.randomPicklesName().toString(), list1.subList(0,i));
            }
        }
        return allJars;
    }
        /**
         * Взять банку по наклейке
         **/
        public static String getJar (String name) throws Exception {
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
                    throw new Exception("Такое соленье отсутствует в погребе");
                }
            }
            return allJars.toString();
        }

        /**
         * Положить банку в погреб
         **/
        public static void setJar (String picklesName, List < String > vegetables) throws Exception {
            copyAllJars.put(picklesName, vegetables.toString());
            if (r <= 1) {
                throw new Exception("Вы уронили банку и она разбилась");
            } else if (!allJars.containsKey(picklesName)) {
                allJars.put(picklesName, vegetables);
                System.out.println("Вы положили в погреб: " + copyAllJars);
            } else if (allJars.containsKey(picklesName)) {
                System.out.println(copyAllJars + " уже есть в погребе, поместите, пожалуйста другую банку");
            }
        }

        /**
         * Содержимое погреба
         **/
        public static void showCountCellar () {
            System.out.println("В погребе сейчас: " + allJars.entrySet());
        }
}


