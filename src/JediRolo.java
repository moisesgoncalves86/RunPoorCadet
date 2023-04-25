import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class JediRolo  extends GameObjects {

    public JediRolo() {
        super();
        Picture pic = new Picture(getInitialCol(), getInitialRow(), "ResizeRolo.png");
        setPicture(pic);
        pic.draw();
    }


    @Override
    public void fall() {
        super.fall();
    }
}