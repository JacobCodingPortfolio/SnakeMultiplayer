package pl.game.client.logic;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import pl.game.client.Game;
import pl.game.client.component.AbstractNode;
import pl.game.client.component.Roomer;
import pl.game.client.connection.Connector;
import pl.game.client.util.Const;
import pl.game.client.util.Logger;
import pl.game.common.model.Table;
import pl.game.common.model.TableRoomRequest;
import pl.game.common.model.TableRoomResponse;
import pl.game.common.model.User;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Presenter implements Runnable {

    private Game game;

    private boolean gameRefresh = false;
    private boolean roomRefresh = false;

    public Presenter(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        int i = 0;
        long startToPing = System.currentTimeMillis();
        long endToPing;

        while (true){


            if(gameRefresh && roomRefresh) {
                break; //TODO - Make sth go wrong. For example fatal error message.
            } else if (gameRefresh){







                i++;
                if(i > 10){
                    endToPing = System.currentTimeMillis();
                    long time = endToPing - startToPing;
                    long fps = (i * Const.MILIS_IN_SECOND) / time;
                    Platform.runLater(() -> { //Eliminating synchronized problem
                        game.getHeader().getHeaderFpsTextField().setText(String.valueOf(fps)); //Set the fps value to the text field
                    });
                    i = 0;
                    startToPing = System.currentTimeMillis();
                }

                try {
                    Thread.sleep(Const.REFRESH_GAME_INTERVAL_MILLISECONDS, Const.REFRESH_GAME_INTERVAL_NANOSECONDS);
                } catch (InterruptedException e) {
                    Logger.log("Presenter thread problem.");
                    e.printStackTrace();
                }

            } else if (roomRefresh){

                //Logger.log("Room refresh.");
                TableRoomRequest roomRequest = new TableRoomRequest();
                roomRequest.setUserId(game.getUserId());
                roomRequest.setActualTableId(null);
                roomRequest.setWantToJoinTableId(null);
                roomRequest.setCreateNewTableName(null);
                TableRoomResponse tableRoomResponse = Connector.refreshRoom(roomRequest);

                AbstractNode abstractNode = game.getGameArea().getGameAreaContent();
                if(abstractNode != null && abstractNode instanceof Roomer){
                    Roomer roomer = (Roomer) abstractNode;
                    roomer.getGameUsers().getItems().removeAll(roomer.getGameUsers().getItems());
                    List<User> userList = tableRoomResponse.getUsers();
                    if(userList != null){
                        for(User user: userList){
                            roomer.getGameUsers().getItems().add(user);
                        }
                    }
                    roomer.getGameTables().getItems().removeAll(roomer.getGameTables().getItems());
                    List<Table> tableList = tableRoomResponse.getTables();
                    if(tableList != null){
                        for(Table table: tableList){
                            roomer.getGameTables().getItems().add(table);
                        }
                    }
                }


                try {
                    Thread.sleep(Const.REFRESH_ROOM_INTERVAL_MILLISECONDS, Const.REFRESH_ROOM_INTERVAL_NANOSECONDS);
                } catch (InterruptedException e) {
                    Logger.log("Presenter thread problem.");
                    e.printStackTrace();
                }
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

    public void switchToGameMode(){
        gameRefresh = true;
        roomRefresh = false;
    }

    public void switchToRoomMode(){
        gameRefresh = false;
        roomRefresh = true;
        Platform.runLater(() -> {
            game.getHeader().getHeaderFpsTextField().setText(String.valueOf(Const.EMPTY_STRING)); //Set the fps value to the text field
        });

    }

}












