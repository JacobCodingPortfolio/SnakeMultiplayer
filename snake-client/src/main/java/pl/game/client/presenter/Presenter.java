package pl.game.client.presenter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.game.client.Game;
import pl.game.client.util.Const;
import pl.game.client.util.Logger;

public class Presenter implements Runnable {

    private Game game;

    public Presenter(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (true){


            

//            GraphicsContext context = Game.getGameInstance().getGameArea().getScreen().getScreenCanvas().getGraphicsContext2D();
//            context.setFill(Color.RED);
//            context.fillRect(0, 0, Const.CANVAS_WIDTH,Const.CANVAS_WIDTH);
//            context.fill();
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            context.setFill(Color.GREEN);
//            context.fillRect(0, 0, Const.CANVAS_WIDTH,Const.CANVAS_WIDTH);
//            context.fill();
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
////            context.setFill(Color.GREEN);
////            context.fillRect(0, 0, 10,10);
////            context.fill();
//
//            for(int i=0; i<Const.CANVAS_WIDTH; i++){
//                for(int j=0; j<Const.CANVAS_HEIGHT; j++){
//                    context.setFill(Color.BLUE);
//                    context.fillRect(i, j, 1,1);
//                    context.fill();
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }





            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Logger.log("Presenter thread problem.");
                e.printStackTrace();
            }
        }

    }

}
