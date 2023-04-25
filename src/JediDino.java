import org.academiadecodigo.simplegraphics.pictures.Picture;

import org.academiadecodigo.simplegraphics.graphics.Color;
        import org.academiadecodigo.simplegraphics.pictures.Picture;
        import org.academiadecodigo.simplegraphics.graphics.Rectangle;

        import java.awt.*;

public class JediDino  extends GameObjects {

    public JediDino() {
        super();
        Picture pic = new Picture(getInitialCol(), getInitialRow(), "ResizeDino.png");
        setPicture(pic);
        pic.draw();
    }


    @Override
    public void fall() {
        super.fall();
    }
}

