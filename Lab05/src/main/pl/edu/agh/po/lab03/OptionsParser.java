package pl.edu.agh.po.lab03;

import pl.edu.agh.po.lab01.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {


    public static List<MoveDirection> parse(String[] directions) {
        List<MoveDirection> result = new ArrayList<MoveDirection>();
        for(String argument : directions) {
            switch (argument) {
                case "f", "forward" -> result.add(MoveDirection.FORWARD);
                case "b", "backward" -> result.add(MoveDirection.BACKWARD);
                case "r" , "right" -> result.add(MoveDirection.RIGHT);
                case "l", "left" -> result.add(MoveDirection.LEFT);
            }
        }
        return result;
    }
}
