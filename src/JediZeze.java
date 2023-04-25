import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class JediZeze  extends GameObjects {

    public JediZeze() {
        super();
        Picture pic = new Picture(getInitialCol(), getInitialRow(), "ResizeZeze.png");
        setPicture(pic);
        pic.draw();
    }


    @Override
    public void fall() {
        super.fall();
    }
}