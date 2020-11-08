package pl.edu.agh.po;

import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab03.OptionsParser;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab05.Grassfield;

import java.util.List;

public class World {
    public static void main(String[] args) {

        String[] arguments = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        List<MoveDirection> directions = OptionsParser.parse(arguments);
        IWorldMap map = new Grassfield(10);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map);

    }
}

