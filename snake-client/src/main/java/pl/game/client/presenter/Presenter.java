package pl.game.client.presenter;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import pl.game.client.Game;
import pl.game.client.util.Const;
import pl.game.client.util.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Presenter implements Runnable {

    private Game game;
    private boolean gameRun;

    public Presenter(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        int i = 0;
        long start = System.currentTimeMillis();
        long end;

        while (true){

            //Image image = getImage(Const.CANVAS_WIDTH_INT, Const.CANVAS_HEIGHT_INT);
            //GraphicsContext context = game.getGameArea().getScreen().getScreenCanvas().getGraphicsContext2D();
            //context.drawImage(image, 0,0);





            i++;
            if(i > 10){
                end = System.currentTimeMillis();
                long time = end - start;
                long fps = (i * Const.MILIS_IN_SECOND) / time;
                Platform.runLater(() -> { //Eliminating synchronized problem
                    game.getHeader().getHeaderFpsTextField().setText(String.valueOf(fps)); //Set the fps value to the text field
                });
                i = 0;
                start = System.currentTimeMillis();
            }

            try {
                Thread.sleep(0, 1);
            } catch (InterruptedException e) {
                Logger.log("Presenter thread problem.");
                e.printStackTrace();
            }
        }
    }


    private Image getImage(int width, int height){
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                bufferedImage.setRGB(x, y, Color.RED.getRGB());
            }
        }
        return SwingFXUtils.toFXImage(bufferedImage, null);
    }

}












