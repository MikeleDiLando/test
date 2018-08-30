package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.control.GayController;

public class Gay extends GameObject {

    private GayController gayController;

    public Gay(TextureRegion textureRegion, float x, float y, float width, float height) {
        super(textureRegion, x, y, width, height);
        gayController = new GayController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        gayController.handle();
    }
}
