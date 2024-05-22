import model.GridNumber;
import view.GameFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 创建 GridNumber 实例
            GridNumber grid = new GridNumber(4, 4);

            // 打印初始状态
            System.out.println("Initial state:");
            grid.printNumber();

            // 执行向右移动操作
            grid.moveRight();
            grid.moveLeft();
            grid.moveUp();
            grid.moveDown();

            // 打印移动后的状态
            System.out.println("After moving right:");
            grid.printNumber();

            // 创建并显示游戏窗口
          //  GameFrame gameFrame = new GameFrame(700, 500);
           // gameFrame.setVisible(true);


        });
    }
}