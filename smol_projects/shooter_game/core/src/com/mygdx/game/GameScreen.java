package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {



    // World
    private World world;

    // Screen Part
    private Camera camera;
    private Viewport viewport;

    // Graphics Part
    private SpriteBatch batch;
    // Graphics Part (Background)

    private Texture background;
    //private Texture background; *removed so that it can have many layers --ingon si Idel Brandon**
    private Texture[] backgrounds;

    // Timing
//    private float[] backgroundOffset = {0, 0, 0, 0};
//    private float backgroundMaxScrollingSpeed;
    private int backgroundOffset;


    // World ( Parameters)
    private final int WORLD_WIDTH = 72;
    private final int WORLD_HEIGHT = 128;

    GameScreen(){

        camera = new OrthographicCamera(); // Orthographic = 2d camera s
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera); // the view on your screen

        background = new Texture("background_map.png");
        backgroundOffset = 0;

        batch = new SpriteBatch();

    }


    @Override
    public void render(float deltaTime) {
        batch.begin(); // starts render

        //zoom factor
        float zoomFactor = 8.0f;
        float mapWidth = WORLD_WIDTH * zoomFactor;
        float mapHeight = WORLD_HEIGHT * zoomFactor;
        float mapX = (WORLD_WIDTH - mapWidth) / 2; // Center the map horizontally
        float mapY = (WORLD_HEIGHT - mapHeight) / 2; // Center the map vertically


        //scrolling background
        backgroundOffset++;
        if(backgroundOffset % mapY == 0){
            backgroundOffset = 0;
        }

    /*    batch.draw(background, 0, -backgroundOffset, WORLD_WIDTH, WORLD_HEIGHT);
          non zoomed background
    */
        batch.draw(background, mapX, mapY, mapWidth, mapHeight);
//        batch.draw(background, mapX, -backgroundOffset+mapY, mapWidth, mapHeight);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);


        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

    @Override
    public void dispose() {

    }
}
