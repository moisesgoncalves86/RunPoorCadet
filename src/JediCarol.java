import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class JediCarol  extends GameObjects {

    public JediCarol() {
        super();
        Picture pic = new Picture(getInitialCol(), getInitialRow(), "ResizeCarol.png");
        setPicture(pic);
        pic.draw();
    }


    @Override
    public void fall() {
        super.fall();
    }
}