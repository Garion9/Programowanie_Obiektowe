package pl.edu.agh.po;

import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab03.OptionsParser;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab05.Grassfield;

import java.util.List;

public class World {
    public static void main(String[] args) {

        try {
            String[] arguments1 = {"f","Jump!","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
            List<MoveDirection> directions1 = OptionsParser.parse(arguments1);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }

        try {
            String[] arguments2 = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
            List<MoveDirection> directions2 = OptionsParser.parse(arguments2);
            IWorldMap map = new Grassfield(10);
            map.place(new Animal(map));
            map.place(new Animal(map));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }

    }
}

