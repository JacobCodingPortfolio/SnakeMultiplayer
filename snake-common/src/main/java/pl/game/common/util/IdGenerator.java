package pl.game.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGenerator {
    private static final int CHARS_COUNT = 20;
    public static String generateObjectIdentification(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmssSS");
        Date date1 = new Date();
        Random random = new Random();
        Integer randomNum = Math.abs(random.nextInt());
        String id = dateFormat.format(date1) + randomNum.toString();
        Integer len = id.length();
        if(len > CHARS_COUNT){
            len = CHARS_COUNT;
        }
        return (id).substring(0, len - 1);
    }
}
