

import java.util.ArrayList;
import java.util.List;

class GameController extends Player{

    private Player player;
    private List<Integer[][]> maps = new ArrayList<>();
    private int globalGameLvl = 1;

    {
        Integer[][] map1 = new Integer[][] {

                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 2, 2, 2, 2, 9, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        };
        maps.add( map1 );

        Integer[][] map2 = new Integer[][] {

                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 2, 3, 4, 9, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        };
        maps.add( map2 );

        Integer[][] map3 = new Integer[][] {

                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 2, 2, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 2, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 2, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 9, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        };
        maps.add( map3 );

        Integer[][] map4 = new Integer[][] {

                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 2, 2, 3, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1 },
                { 1, 1, 1, 9, 2, 2, 3, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        };
        maps.add( map4 );

        Integer[][] map5 = new Integer[][] {

                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 2, 3, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 2, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 2, 1, 1, 1, 1 },
                { 1, 1, 1, 9, 2, 4, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        };
        maps.add( map5 );
    }

    GameController() {
    }

    void setPlayer(Player player) {

        this.player = player;
        this.player.setAlive( true );
        this.player.setEyeDirection( EyeDirection.EAST );
    }

    private void restart() {

        player.refresh();
        globalGameLvl = 1;
    }

    void startMGL() {
        while( true ) {
            if( player.isAlive() ) {
                if( globalGameLvl == 1 ) {
                    startLvl( globalGameLvl );
                } else {
                    boolean startNextLvl = ConsoleReader.chooseYN();
                    if( startNextLvl ) {
                        startLvl( globalGameLvl );
                    } else {
                        printBye();
                        System.exit( 0 );
                    }
                }
                if( player.isAlive() ) {
                    if( globalGameLvl < maps.size() ) {
                        printCongrats();
                        globalGameLvl++;
                    } else {
                        printEnd();
                        boolean startNewGame = ConsoleReader.chooseYN();
                        if( startNewGame ) {
                            restart();
                        } else {
                            printBye();
                            System.exit( 0 );
                        }
                    }
                }
            } else {

                boolean startNewGame = ConsoleReader.chooseYN();
                if( startNewGame ) {

                    restart();
                } else {

                    printBye();
                    System.exit( 0 );
                }
            }
        }
    }

    private void startLvl( int gameLvl ) {

        printLvlLoad();
        Map map = new Map( maps.get( gameLvl - 1 ) );
        map.setPlayer( player );
        printGameField( map );
        GameElement failedElement = null;
        boolean isFinished = false;
        while( player.isAlive() ) {

            List<Action> actionList = ConsoleReader.readAction();
            for ( Action action :
                    actionList ) {

                for (int i = 0; i < action.getRepeater(); i++) {

                    failedElement = update( map, action );
                    printGameField( map );
                    if( failedElement != null ) {

                        printFail( failedElement );
                        break;
                    }
                    if( map.isFinished( player.getX(), player.getY() ) ) {

                        isFinished = true;
                        break;
                    }
                }
            }
            if(  isFinished || !player.isAlive() ) {

                break;
            }
        }
    }

    private GameElement update( Map map, Action action ) {

        int element = action.getElement();
        Movement movement = action.getMovement();
        int currentElement = map.getCurrentElement( player );
        GameElement failedElement = null;
        if( element != currentElement ) {

            player.setAlive( false );
            failedElement = GameElement.getElementByCode( currentElement );
            return failedElement;
        }
        player.move( movement );
        if( map.isObstacle( player.getX(), player.getY() ) ) {

            failedElement = GameElement.OBSTACLE;
            player.setAlive( false );
            return failedElement;
        }
        return null;
    }


    private void printGameField( Map map ) {

        ConsoleView.printField( map, player );
    }

    private void printLvlLoad() {

        ConsoleView.printLvlLoad( globalGameLvl );
    }

    private void printCongrats() {

        ConsoleView.congrats( globalGameLvl );
    }

    private void printFail( GameElement failedElement ) {

        ConsoleView.printFail( failedElement );
    }

    private void printBye() {

        ConsoleView.printBye();
    }

    private void printEnd() {

        ConsoleView.printEnd();
    }
}
