package src.main.java.controller;

import src.main.java.model.GridNumber;
import src.main.java.view.GamePanel;


/**
 * This class is used for interactive with JButton in GameFrame.
 */
public class GameController {
    private GamePanel view;
    private src.main.java.model.GridNumber model;


    public GameController(GamePanel view, src.main.java.model.GridNumber model) {
        this.view = view;
        this.model = model;

    }
    public void restartGame() {
        System.out.println("Do restart game here");
    }

    //todo: add other methods such as loadGame, saveGame...

}
