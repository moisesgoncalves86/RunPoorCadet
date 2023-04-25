import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class JediJoao  extends GameObjects {

    public JediJoao() {
        super();
        Picture pic = new Picture(getInitialCol(), getInitialRow(), "ResizeJoao.png");
        setPicture(pic);
        pic.draw();
    }


    @Override
    public void fall() {
        super.fall();
    }
}