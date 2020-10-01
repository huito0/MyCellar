import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        /**
         * Рандомное заполнение погреба
         **/
        System.out.println(Vault.generateArrayJars());

        /**
         * Взять банку по наклейке
         **/
        try {
            Vault.getJar(PicklesName.SALTBROCCOLI.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /**
         Положить банку в погреб
         **/
        List<String> vegStr = new ArrayList<>();
        vegStr.add(Vegetables.PEPPER.toString());
        vegStr.add(Vegetables.POTATO.toString());
        vegStr.add(Vegetables.TOMATO.toString());

        Vault.setJar(PicklesName.ASSORTI.toString(), vegStr);

        /**
         * Проверяем наличие банок в погребе
         **/
        Vault.showCountCellar();
    }
}
