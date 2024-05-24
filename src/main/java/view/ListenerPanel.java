package src.main.java.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * This class is to enable key events.
 *
 */
public abstract class ListenerPanel extends JPanel {
    public ListenerPanel() {
        enableEvents(AWTEvent.KEY_EVENT_MASK);
        this.setFocusable(true);
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        super.processKeyEvent(e);
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT -> doMoveRight();
                //todo: complete other move event
            }
        }
    }


    public abstract void doMoveRight();

    public static class Main extends Application {

        @Override
        public void start(Stage primaryStage) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/YourFXMLFile.fxml"));
                Scene scene = new Scene(loader.load());
                primaryStage.setScene(scene);
                primaryStage.setTitle("2048 Game");
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
}
