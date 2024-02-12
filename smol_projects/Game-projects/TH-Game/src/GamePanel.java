import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // screen settings
    final int originalTileSize = 16; // 16 x 16 title
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48 x 48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    // 16 tiles horizontally // 12 tiles vertically resulting into a ratio of 4 x 3
    final int screenWidth = tileSize * maxScreenCol; // 768 pixel
    final int screenHeight = tileSize * maxScreenRow; // 576 pixel

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        // if DoubleBuffered set true all drawing from this component will be done in
        // an offscreen painting buffer
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }
}
