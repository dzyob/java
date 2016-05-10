import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class PsevdoSimpleDotComTestDrive {
    public static void main(String[] args) throws IOException{

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        SimpleDotCom dot = new SimpleDotCom();
        Parametrs settings = new Parametrs();

        int count = 0;                                              // количество попыток с которых удалось угадать
        String result="Мимо";                                       // результат изначально "Мимо"

        System.out.println("Уровень сложности. Длина поля: ");
        int weight = Integer.parseInt(r.readLine());
        settings.setWeight(weight);                                 // задаём значение длины строки

        System.out.println("Размер корабля: ");
        int size = Integer.parseInt(r.readLine());
        settings.setSizeShip(size);                                 // задаём значение длины корабля

        int random = (int) (Math.random() * ((settings.getWeight()-settings.getSizeShip())+1));

        String[] locations = new String[settings.getWeight()];      // создаем массив
        for (int i = 0; i < locations.length; i++) {                // вставляем кораблик в пположенное место
            if(i == random) {
                for (int j = 0; j < settings.getSizeShip(); j++) {
                    locations[i+j] = String.valueOf(random+j);
                }
            }
        }

        String[] locationsDuplicate = new String[locations.length]; // делаем дубликат массива
        for (int i = 0; i < locations.length; i++) {                // инициализируем дубликат
            locationsDuplicate[i]=locations[i];
        }

        dot.setLocationCells(locations);                            // присваиваем массив для обработки

        while(!result.equals("Потопил")) {
            System.out.println("Введи число: ");
            String n = r.readLine();
            result = dot.checkYourself(n, settings.getSizeShip());
            count++;
            System.out.println("");
        }
        System.out.println("======================================");
        System.out.println("Вам понадобилось "+count+" попыток(и)");
        System.out.println("");
        System.out.println("Вот так вот был размещён корабль: ");
        System.out.println("");
        for (String g : locationsDuplicate) {
            System.out.println("# "+g);
        }
        System.out.println("======================================");
    }

}
class SimpleDotCom {
    String[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(String[] locs){
        locationCells = locs;
    }
    public String checkYourself(String n, int z) {
        String guess = n;
        String result = "Мимо";
        for (int i = 0; i < locationCells.length; i++) {
            if (guess.equals(locationCells[i])) {
                result = "Попал";
                numOfHits++;
                locationCells[i] = null;
                break;
            }
        }
        if (numOfHits == z){
            result = "Потопил";
        }
        System.out.println(result);
        System.out.println("Подбито частей корабля: "+numOfHits);
        return result;
    }
}
class Parametrs {
    private int weight = 7;
    private int sizeShip = 3;

    public void setWeight(int weightArg){
        if(weightArg < 7){
            weight = 7;
        } else if (weightArg > 21) {
            weight = 21;
        } else {
            weight = weightArg;
        }
    }

    public int getWeight(){
        return weight;
    }

    public void setSizeShip(int sizeShipArg){
        if(sizeShipArg < 1){
            sizeShip = 1;
        } else if (sizeShipArg > 5) {
            sizeShip = 5;
        } else {
            sizeShip = sizeShipArg;
        }
    }

    public int getSizeShip(){
        return sizeShip;
    }

}
