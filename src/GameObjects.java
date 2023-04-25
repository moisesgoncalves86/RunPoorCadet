import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class GameObjects {

    private Field field;
    private boolean crashed = false;
    private Picture picture;
    private int speed;
    private int damage;
    private int initialCol;
    private int initialRow;
    private Rectangle rectangle;

    public GameObjects() {
        field = new Field();
        initialCol = (int) (Math.random() * (Field.width - 86));
        initialRow = Field.PADDING + 80;
        speed = 1;
        damage = 20;
    }

    public void fall() {
        picture.translate(0, speed);
        hitBox().translate(0, speed);
        System.out.println(speed);
    }


    public Rectangle hitBox() {
        return rectangle = new Rectangle(picture.getX() + 30, picture.getY() + 30,picture.getWidth() - 40, picture.getHeight());
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getInitialCol() {
        return initialCol;
    }

    public int getInitialRow() {
        return initialRow;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}