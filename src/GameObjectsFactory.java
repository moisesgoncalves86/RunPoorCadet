public class GameObjectsFactory {
    private GameObjects game;

    public Object getNewObject() {


        int random = (int) (Math.random() * Objects.values().length);
        Objects objType = Objects.values()[random];

        game = new GameObjects();

        switch (objType) {
            case JEDINUNO:
                game = new JediNuno();
                break;
            case JEDIROLO:
                game = new JediRolo();
                break;
            case JEDIRAQUEL:
                game = new JediRaquel();
                break;
            case BEER:
                game = new Beer();
                break;
            case JEDIDINO:
                game = new JediDino();
                break;
            case JEDIZEZE:
                game = new JediZeze();
                break;
            case BEER2:
                game = new Beer();
                break;
            case JEDIZUKA:
                game = new JediZuka();
                break;
            case JEDICAROL:
                game = new JediCarol();
                break;
            case JEDIJOAO:
                game = new JediJoao();
                break;
            default:
                return new JediNuno();
        }
        return game;
    }
}