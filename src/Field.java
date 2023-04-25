
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    public static final int height = 750;
    public static final int width = 1250;
    public static final int PADDING = 10;
    public Picture background;

    public Field() {
    }

    public void fieldInit() {
        background = new Picture(PADDING, PADDING, "NewGameBackground.png");
        background.draw();
    }

    public Picture getBackground() {
        return background;
    }

    public void setBackground(Picture background) {
        this.background = background;
    }
}

