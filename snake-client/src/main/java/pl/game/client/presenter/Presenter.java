package pl.game.client.presenter;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import pl.game.client.Game;
import pl.game.client.util.Const;
import pl.game.client.util.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Date;

public class Presenter implements Runnable {

    private Game game;

    public Presenter(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        int i = 0;
        Date startDate = new Date();
        Date endDate;

        while (true){

            Image image = getImage(Const.CANVAS_WIDTH_INT, Const.CANVAS_HEIGHT_INT);
            GraphicsContext context = game.getGameArea().getScreen().getScreenCanvas().getGraphicsContext2D();
            context.drawImage(image, 0,0);

            i++;

            if(i > 100){
                endDate = new Date();
                int time = (int) (endDate.getTime() - startDate.getTime());
                int fps = (i * Const.MILIS_IN_SECOND) / time;
                Logger.log("Ilość klatek na sekunde: " + String.valueOf(fps));
                i = 0;
                startDate = new Date();
            }

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
//            context.setFill(Color.GREEN);
//            context.fillRect(0, 0, 10,10);
//            context.fill();
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
                Thread.sleep(0, 1);
            } catch (InterruptedException e) {
                Logger.log("Presenter thread problem.");
                e.printStackTrace();
            }
        }

    }


    private Image getImage(int width, int height){
        //WritableImage writableImage = new WritableImage(width, height);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                bufferedImage.setRGB(x, y, Color.RED.getRGB());
            }
        }

//        PixelWriter pixelWriter = writableImage.getPixelWriter();
//        Color color;
//        for(int i=0;i<width;i++){
//            for(int j=0;j<height;j++){
// ColorSelector.getRandomColor();
//                pixelWriter.setColor(i, j, color);
//            }
//        }
//        return writableImage;
    return SwingFXUtils.toFXImage(bufferedImage, null);
    }

}












