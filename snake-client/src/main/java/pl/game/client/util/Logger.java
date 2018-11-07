package pl.game.client.util;

import java.util.Date;

public class Logger {

    private static Date actualDate;

    public static void log (String... logs){
        for(String l: logs){
            actualDate = new Date();
            System.out.println(actualDate.toString() + Const.LOGGER_ARROW + l);
        }
    }

}
