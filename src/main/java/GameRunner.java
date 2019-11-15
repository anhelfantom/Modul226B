public class GameRunner extends GameController{

    public static void main(String[] args) {
        Player player = new Player();
        GameController controller = new GameController();
        controller.setPlayer( player );
        controller.startMGL();
    }
}

