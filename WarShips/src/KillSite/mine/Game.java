package KillSite.mine;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException{
        gameMechanic dot = new gameMechanic();
        Parameters settings = new Parameters();
        createDuplicate duplicate = new createDuplicate();

        settings.setWeight(); // размер поля
        settings.setSizeShip(); // размер корабля
        String[] locations = settings.makeList(); // создаём ячейки поля
        duplicate.setOrigin(locations);
        String[] locationsDuplicate = duplicate.makeDuplicate();

        dot.setLocationCells(locations);
        dot.setLocationCellsDuplicate(locationsDuplicate);
        dot.makeGame(settings.getSizeShip(), locationsDuplicate);
    }
}

