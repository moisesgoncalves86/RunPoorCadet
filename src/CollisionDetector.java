import java.util.LinkedList;
public class CollisionDetector {
    private LinkedList<GameObjects> list;
    private Cadet cadet;
    private Field field;

    private GameSounds saberHitSound = new GameSounds("saberhit.wav");
    private GameSounds beerHitSound = new GameSounds("beersound.wav");
    public CollisionDetector(LinkedList<GameObjects> list, Cadet cadet, Field field) {
        this.list = list;
        this.cadet = cadet;
        this.field = field;
    }

    public void jediCollision() {

        for (int i = 0; i < list.size(); i++) {
            if (cadet.hitBox().getY() < list.get(i).hitBox().getY() + 100 &&
                    list.get(i).hitBox().getX() + list.get(i).hitBox().getWidth() > cadet.hitBox().getX() &&
                    list.get(i).hitBox().getX() < cadet.hitBox().getX() + cadet.hitBox().getWidth()) {

                if (list.get(i) instanceof Beer) {
                    beerHitSound.play(true);
                    list.get(i).getPicture().delete();
                    list.remove(list.get(i));
                    cadet.setScore(cadet.getScore() + 20);

                    if (cadet.getHp() <= 80) {
                        cadet.setHp(cadet.getHp() + 20);
                    }
                    continue;
                }
                saberHitSound.play(true);
                cadet.setHp(cadet.getHp() - list.get(i).getDamage());
                list.get(i).getPicture().delete();
                list.remove(list.get(i));
            }
        }
    }

    public void fieldCollision() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).hitBox().getY() + 100 >= field.background.getHeight()) {
                list.get(i).getPicture().delete();
                list.remove(list.get(i));
                list.get(i).hitBox().delete();
                cadet.setScore(cadet.getScore() + 50);

                if (list.get(i) instanceof Beer) {
                    list.get(i).getPicture().delete();
                    list.remove(list.get(i));
                }
            }
        }
    }
}


