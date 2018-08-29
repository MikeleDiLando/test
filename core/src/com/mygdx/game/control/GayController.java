package com.mygdx.game.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.view.GameScreen;

public class GayController {

    private Polygon gayBounds;

    public GayController (Polygon gayBounds) {
        this.gayBounds = gayBounds;
    }

    private float speed, velocity = 10f, speedMAX = 10f, rotationSpeed = 30f;

    public void handle () {
        // работа со скоростью
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            speed += velocity * GameScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            speed -= velocity * GameScreen.deltaCff;
        else
            downSpeed();

        speed = sliceSpeed();
        //

        //робота с поворотами
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            gayBounds.rotate(rotationSpeed * speed * GameScreen.deltaCff);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            gayBounds.rotate(-rotationSpeed * speed * GameScreen.deltaCff);
        //

        gayBounds.setPosition(gayBounds.getX() + MathUtils.cosDeg(gayBounds.getRotation() + 90) * speed * GameScreen.deltaCff,
                              gayBounds.getY() + MathUtils.sinDeg(gayBounds.getRotation() + 90) * speed * GameScreen.deltaCff);

    }

    private void downSpeed() {          //гасит скорость
        if (speed > velocity * GameScreen.deltaCff)
            speed -= velocity * GameScreen.deltaCff;
        else if (speed < -velocity * GameScreen.deltaCff)
            speed += velocity * GameScreen.deltaCff;

        speed = 0f;
    }

    private float sliceSpeed () {       //ограничивает скорость
        if (speed > speedMAX)
            return speedMAX;
        else if (speed < -speedMAX)
            return -speedMAX;

        return speed;
    }
}
