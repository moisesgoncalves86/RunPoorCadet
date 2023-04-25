import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class JediRaquel  extends GameObjects {

    public JediRaquel() {
        super();
        Picture pic = new Picture(getInitialCol(), getInitialRow(), "ResizeRaquel.png");
        setPicture(pic);
        pic.draw();
    }


    @Override
    public void fall() {
        super.fall();
    }
}