package pl.edu.agh.po;

import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab03.OptionsParser;
import pl.edu.agh.po.lab05.AbstractWorldMap;
import pl.edu.agh.po.lab05.Grassfield;

import java.util.List;

public class World {
    public static void main(String[] args) {

        String[] arguments = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        List<MoveDirection> directions = OptionsParser.parse(arguments);
        AbstractWorldMap map = new Grassfield(10);
        Animal animal1 = new Animal(map);
        map.place(animal1);
        Animal animal2 = new Animal(map, new Vector2d(3,4));
        map.place(animal2);
        System.out.println(map);
        map.run(directions);
        System.out.println(map);



        /*
        try {
            String[] arguments1 = {"f","Jump!","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
            List<MoveDirection> directions1 = OptionsParser.parse(arguments1);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }

        try {
            String[] arguments2 = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
            List<MoveDirection> directions2 = OptionsParser.parse(arguments2);
            IWorldMap map2 = new Grassfield(10);
            map2.place(new Animal(map2));
            map2.place(new Animal(map2));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        */

    }
}

