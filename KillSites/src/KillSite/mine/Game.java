package KillSite.mine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Game {
    public static void main(String[] args) throws IOException{

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        gameMechanic dot = new gameMechanic();
        Parameters settings = new Parameters();

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

