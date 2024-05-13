package com.mygdx.game.map;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.PlayerManager;
import utils.TiledObjectUtil;

import static utils.Constants.PPM;
import static com.mygdx.game.PlayerManager.player;


public class Map {
    private TiledMap map;
    Texture[] test_map_textures;
    OrthogonalTiledMapRenderer tmr;

    public Map(World world, SpriteBatch batch){
        map = new TmxMapLoader().load("assets/map_textures/map.tmx");
        tmr = new OrthogonalTiledMapRenderer(map);



        TiledObjectUtil.parseTiledObjectLayer(world, map.getLayers().get("collision_layer").getObjects());

        test_map_textures = new Texture[]{
                new Texture("assets/map_textures/map_terrain.png"),
                new Texture("assets/map_textures/map_tree01.png"),
                new Texture("assets/map_textures/map_tree02.png"),
                new Texture("assets/map_textures/map_tree03.png"),
                new Texture("assets/map_textures/map_tree04.png"),
                new Texture("assets/map_textures/map_tree05.png"),
        };


    }

    public void drawLayerTextures(SpriteBatch batch, TextureRegion textregion) {
        for (int i = 0; i < test_map_textures.length; i++) {
            Texture texturez = test_map_textures[i];
            if (i == 4) { // Check if it's the layer for the player
                batch.draw(textregion, player.getPosition().x * PPM - ((float) textregion.getRegionWidth() / 2), player.getPosition().y * PPM - ((float) textregion.getRegionHeight() / 8));
            }
            batch.draw(texturez, 0, 0);
        }

    }

    public void dispose() {
        tmr.dispose();
    }

    public TiledMap getMap() {
        return map;
    }





}
