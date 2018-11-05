package pl.game.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author JNartowicz
 */
@RestController
public class Text {

    private static List<Integer> integers = new ArrayList<Integer>();

    static {
        System.out.println("Wykonywanie.");
        for(int i = 0; i < 100000 ; i++){
            integers.add(i);
        }
        System.out.println("Wykonano.");
    }

    @RequestMapping("/test")
    public String test(){

        Random random = new Random();
        int r = Math.abs(random.nextInt() % (integers.size() - 20));
        System.out.println("Pobrało liczbę: " + integers.get(r));
        return "Zwrócono.";
    }

}
