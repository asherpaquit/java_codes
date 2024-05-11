package com.mygdx.game.map;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

public class Map {
    private static final String TAG = Map.class.getSimpleName();
    private final TiledMap tiledMap;

    public OrthogonalTiledMapRenderer tmr;
   // private final Array<CollisionArea> collisionAreas;
    private final Vector2 startLocation;

    public Map(final TiledMap tiledMap) {
        final MapProperties mapProps = tiledMap.getProperties();
        this.tiledMap = tiledMap;

      //  this.collisionAreas = new Array<>();
        //this.camBoundaries = new Array<>();
        this.startLocation = new Vector2(mapProps.get("playerStartTileX", 0f, Float.class), mapProps.get("playerStartTileY", 0f, Float.class));

        parseCollision();

    }
    private void parseCollision() {
        final MapLayer collisionLayer = tiledMap.getLayers().get("collision");
        if (collisionLayer == null) {
            Gdx.app.log(TAG, "Map does not have a layer called 'collision'");
            return;
        }

        for (final MapObject mapObj : collisionLayer.getObjects()) {
            if (mapObj instanceof PolylineMapObject) {
                final Polyline polyline = ((PolylineMapObject) mapObj).getPolyline();
           //     collisionAreas.add(new CollisionArea(polyline.getX(), polyline.getY(), polyline.getVertices()));
            } else if (mapObj instanceof RectangleMapObject) {
                final Rectangle rect = ((RectangleMapObject) mapObj).getRectangle();
                final float[] rectVertices = new float[10];
                // left-bot
                rectVertices[0] = 0;
                rectVertices[1] = 0;
                // left-top
                rectVertices[2] = 0;
                rectVertices[3] = rect.height;
                // right-top
                rectVertices[4] = rect.width;
                rectVertices[5] = rect.height;
                // right-bot
                rectVertices[6] = rect.width;
                rectVertices[7] = 0;
                // left-bot
                rectVertices[8] = 0;
                rectVertices[9] = 0;
           //     collisionAreas.add(new CollisionArea(rect.x, rect.y, rectVertices));
            } else {
                Gdx.app.log(TAG, "Unsupported mapObject for collision layer: " + mapObj);
            }
        }
    }
}
