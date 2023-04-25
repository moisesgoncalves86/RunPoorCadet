import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class JediZuka  extends GameObjects {

    public JediZuka() {
        super();
        Picture pic = new Picture(getInitialCol(), getInitialRow(), "ResizeZuka.png");
        setPicture(pic);
        pic.draw();
    }


    @Override
    public void fall() {
        super.fall();
    }
}