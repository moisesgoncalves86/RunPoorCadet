import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Game implements KeyboardHandler {


    private Picture picture;
    private int delay = 25;
    private Field field;
    private GameObjects gameObjects;
    private Cadet cadet;
    private LinkedList<GameObjects> linkedList;
    private CollisionDetector pum;
    private int level = 1;

    private Text hpText;
    private Text screenScore;
    private Text lvl;

    private boolean gameStarted;

    private GameSounds gameIntro = new GameSounds("maintheme.wav");
    private GameSounds pressStartSound = new GameSounds("saberignition.wav");
    private GameSounds gameOverSound = new GameSounds("gameoverfadeout.wav");
    private GameSounds gamePlay = new GameSounds("soundplay2.wav");


    public void init() throws RuntimeException, InterruptedException {
        while (!gameStarted) {
            System.out.println(" ");
        }
        picture.delete();
        gameIntro.stop();
        gamePlay.play(true);

        this.field = new Field();
        field.fieldInit();

        this.cadet = new Cadet();

        hpText = new Text(175, 725, " " + cadet.getHp());
        hpText.setColor(Color.WHITE);
        hpText.grow(30, 30);
        hpText.draw();

        screenScore = new Text(1130, 725, " " + cadet.getScore());
        screenScore.setColor(Color.WHITE);
        screenScore.grow(30, 30);
        screenScore.draw();

        lvl = new Text(660, 725, " " + level);
        lvl.setColor(Color.WHITE);
        lvl.grow(30, 30);
        lvl.draw();


        GameObjectsFactory gameObjectsFactory = new GameObjectsFactory();
        linkedList = new LinkedList<>();

        pum = new CollisionDetector(linkedList, cadet, field);

        while (cadet.getHp() > 0) {
            nextLevel();

            if (linkedList.size() < 7) {
                gameObjects = (GameObjects) gameObjectsFactory.getNewObject();
                linkedList.add(gameObjects);
                gameObjects.setSpeed(level);


                for (int i = 0; i < linkedList.size(); i++) {
                    for (int j = 0; j < linkedList.size(); j++) {

                        if (i == j) {
                            continue;
                        }

                        if (linkedList.get(i).hitBox().getX() + linkedList.get(i).hitBox().getWidth() > linkedList.get(j).hitBox().getX() &&
                                linkedList.get(i).hitBox().getX() < linkedList.get(j).hitBox().getX() + linkedList.get(j).hitBox().getWidth()) {
                            linkedList.get(j).getPicture().delete();
                            linkedList.remove(linkedList.get(j));
                        }
                    }
                }
            }

            Thread.sleep(delay);

            for (int i = 0; i < linkedList.size(); i++) {
                linkedList.get(i).fall();

                pum.jediCollision();
                pum.fieldCollision();
                screenScore.setText(" " + cadet.getScore());
                hpText.setText(" " + cadet.getHp());
            }
        }
        gameOver();
    }

    public void start() throws InterruptedException {
        picture = new Picture(Field.PADDING, Field.PADDING, "StartScreen.png");
        picture.draw();
        gameIntro.play(true);
        keyboardInit();
        init();
    }

    public void gameOver() throws InterruptedException {
        gamePlay.stop();

        gameOverSound.play(true);

        field.getBackground().delete();
        field.setBackground(new Picture(Field.PADDING, Field.PADDING, "GameOverScreen.png"));
        field.getBackground().draw();
    }

    public void nextLevel() {
        if (cadet.getScore() >= 300 * level) {
            level += 1;
            lvl.setText(" " + level);
        }
    }

    private void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        //SPACE KEY
        KeyboardEvent spaceKeyPressed = new KeyboardEvent();
        spaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKeyPressed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            pressStartSound.play(true);
            gameStarted = true;
            pressStartSound.stop();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
