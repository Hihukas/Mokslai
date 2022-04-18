package Collections;

import java.util.ArrayList;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(2, 5));
        coordinates.add(new Coordinate(1, 5));
        coordinates.add(new Coordinate(5, 9));
        coordinates.add(new Coordinate(4, 0));
        coordinates.add(new Coordinate(0, 0));
        coordinates.add(new Coordinate(9, 1));

        System.out.println(coordinates);
        Task6 task6 = new Task6();
        Coordinate coordinate = task6.findCoordinate(0,0, coordinates);

        if (coordinate == null) {
            System.out.println("Tokios koordinatės nėra");
            return;
        }
        System.out.printf("Koordinatė yra sąrašė %s\n", coordinates.indexOf(coordinate));
        coordinate.setX(1);
        coordinate.setY(1);
        System.out.println(coordinates);
    }

    private Coordinate findCoordinate(int x, int y, List<Coordinate> coordinates) {
        for (Coordinate c : coordinates) {
            if (c.getX() == x && c.getY() == y) {
                return c;
            }
        }
        return null;
    }
}
