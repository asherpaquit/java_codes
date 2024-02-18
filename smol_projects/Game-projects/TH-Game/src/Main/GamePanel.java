package Main;

import javax.swing.*;
import java.awt.*;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
    // screen settings
    final int originalTileSize = 16; // 16 x 16 title
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48 x 48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    // 16 tiles horizontally // 12 tiles vertically resulting into a ratio of 4 x 3
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixel
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixel

    int FPS = 60;
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        // if DoubleBuffered set true all drawing from this component will be done in
        // an offscreen painting buffer
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

//    @Override
//    public void run() {
//        double drawInterval = 1000000000/FPS; // 0.01666 seconds
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while(gameThread != null){
//           // System.out.println("Game loop is running");
//            /*
//            Why use gameThread implementation?
//               1.) Update: para mag sige og update og information pariha anang character positioning
//
//               2.) Draw: maka render siya og unsay naa sa screen
//
//                   like if your character is in coordinates like X: 100, Y:100
//                   when you press down keyboard the character will change it's position.
//                   and if mo hold siya sa down key ang coordinates be like:
//                   100 -> 105 -> 110 -> 115 -> 120
//             */
//
//
//
//            update();
//            repaint();  // how you call the paintComponent
//
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//
//                if(remainingTime < 0){
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long)remainingTime);
//
//                nextDrawTime += drawInterval;
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

    @Override
    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta > 1){
                update();
                repaint();
                delta--;
            }

        }
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        // the Graphics class (Graphics g) has many functions to draw objects on screen
        // whenever you use this function always use super.PaintComponent(g)
        // because gamePanel class is just a subclass of Jpanel
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        //we use Graphics2d because its just a subclass of Graphics and a little bit more specific
        tileM.draw(g2);
        player.draw(g2);


        g2.dispose(); //Dispose: Dispose of this graphics context and release any system resource that is using
        //and save memory


    }
}
