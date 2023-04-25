import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class JediNuno  extends GameObjects {

    public JediNuno() {
        super();
        Picture pic = new Picture(getInitialCol(), getInitialRow(), "ResizeNuno.png");
        setPicture(pic);
        pic.draw();
    }


    @Override
    public void fall() {
        super.fall();
    }
}