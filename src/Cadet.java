import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Cadet implements KeyboardHandler {

    public Picture picture;
    public Rectangle rectangle;
    private int score = 0;
    private int hp = 100;
    private Rectangle cadet;


    private Picture picture2 = new Picture(625, 600, "ResizeCadetLeft.png");




    public Cadet() {
        picture = new Picture(625, 600, "ResizeCadetRight.png");
        picture.draw();
        this.cadet = new Rectangle(picture.getX(), picture.getY(), picture.getWidth(), picture.getHeight());
        keyboardInit();
    }

    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        //RIGHT KEY
        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightKeyPressed);

        //LEFT KEY
        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftKeyPressed);



        //jump
        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(upKeyPressed);

        //jumprelease
        KeyboardEvent upKeyReleased = new KeyboardEvent();
        upKeyReleased.setKey(KeyboardEvent.KEY_UP);
        upKeyReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(upKeyReleased);





    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //MOVE LEFT
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            if (hitBox().getX() > Field.PADDING + 10) {
                hitBox().translate(-20, 0);
                cadet.translate(-20, 0);
                picture.translate(-20, 0);
                /*picture.delete();
                hitBox().delete();
                picture = new Picture(picture.getX(), picture.getY() ,"ResizeCadetLeft.png");
                picture.draw();*/


            }
        }
        //MOVE RIGHT
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            if (hitBox().getX() + hitBox().getWidth() < Field.width + Field.PADDING - 15){
                hitBox().translate(20, 0);
                cadet.translate(20, 0);
                picture.translate(20, 0);
                /*picture.delete();
                hitBox().delete();
                picture = new Picture(picture.getX(), picture.getY() ,"ResizeCadetRight.png");
                picture.draw();*/

            }
        }
        //jump
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP ) {
            if (hitBox().getX() + hitBox().getWidth()  < Field.width + Field.PADDING + 10){
                hitBox().translate(0, -150);
                cadet.translate(0, -150);
                picture.translate(0, -150);
                /*picture.delete();
                hitBox().delete();
                picture = new Picture(picture.getX(), picture.getY() ,"ResizeCadetRight.png");
                picture.draw();*/
            }

        }


    }



    public Rectangle hitBox() {
        return rectangle = new Rectangle(cadet.getX() , cadet.getY() , cadet.getWidth() , cadet.getHeight() );
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void keyReleased (KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            if (hitBox().getX() + hitBox().getWidth()  < Field.width + Field.PADDING + 10) {

                hitBox().translate(0, 150);
                cadet.translate(0, 150);
                picture.translate(0, 150);
                /*picture.delete();
                hitBox().delete();
                picture = new Picture(picture.getX(), picture.getY(), "ResizeCadetRight.png");
                picture.draw();*/


            }

        }
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}

