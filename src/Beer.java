import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Beer extends GameObjects  {
    public Beer() {
        super();
        Picture pic = new Picture(getInitialCol(), getInitialRow(),"OficialBeer.png" );
        setPicture(pic);
        pic.draw();
    }

    @Override
    public void fall() {
        super.fall();
    }
}
