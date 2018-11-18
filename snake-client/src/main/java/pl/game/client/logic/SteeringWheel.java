package pl.game.client.logic;

import pl.game.client.util.Const;

public class SteeringWheel {

    private static Integer angle = 0;
    private static Long lastTimeModified = null;

    private SteeringWheel(){}

    public static synchronized int getAngle(){
        return angle;
    }

    public static synchronized void right(){
        if(minimumBreakHasPassed()){
            setLastTimeModified();
            setAngle(++angle);
        }
    }

    public static synchronized void left(){
        if(minimumBreakHasPassed()){
            setLastTimeModified();
            setAngle(--angle);
        }
    }

    public static synchronized void setAngle(Integer angle) {
        if(angle > Const.FULL_ANGLE){
            SteeringWheel.angle = Const.ZERO_ANGLE;
        } else if(angle < Const.ZERO_ANGLE){
            SteeringWheel.angle = Const.FULL_ANGLE;
        } else {
            SteeringWheel.angle = angle;
        }
    }

    private static synchronized void setLastTimeModified(){
        lastTimeModified = System.currentTimeMillis();
    }

    private static synchronized Long getLastTimeModified(){
        return lastTimeModified;
    }

    private static synchronized boolean minimumBreakHasPassed(){
        if(lastTimeModified == null){
            return true;
        }
        Long currentTimeModified = System.currentTimeMillis();
        if((currentTimeModified - getLastTimeModified()) > Const.BREAK_BETWEEN_KEY_PRESS_REFRESH){
            return true;
        }
        return false;
    }

}
