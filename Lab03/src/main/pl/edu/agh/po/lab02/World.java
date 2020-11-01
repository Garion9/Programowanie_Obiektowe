package pl.edu.agh.po.lab02;

import java.util.List;

public class World {
    public static void main(String[] args) {

        Animal zwierzak = new Animal();
        String[] input = {"f", "r", "gibberish", "forward", "left", "b", "a", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = OptionsParser.parse(input);
        for (MoveDirection argument: directions) {
            zwierzak.move(argument);
            System.out.println(zwierzak);
        }
        //zostal do zrobienia punkt 9
    }
}

