public class ConsoleView extends Map{

    public ConsoleView(Integer[][] map2DArray) {
        super(map2DArray);
    }

    static void printField(Map field, Player player) {
        Integer[][] map = field.getMap2DArray();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[ 0 ].length; j++) {
                if( i == player.getY() && j == player.getX() ) {
                    if( player.isAlive() ) {
                        player.print();
                    } else {
                        System.out.print( "X " );
                    }
                } else {
                    int cell = map[ i ][ j ];
                    if( cell == GameElement.START.getCode() ) {

                        System.out.print( "()" );
                    }
                    if( cell == GameElement.OBSTACLE.getCode() ) {

                        System.out.print( "[]" );
                    } else if( cell == GameElement.RED.getCode() ) {

                        System.out.print( "R " );
                    } else if( cell == GameElement.GREEN.getCode() ) {

                        System.out.print( "G " );
                    } else if( cell == GameElement.BLUE.getCode() ) {

                        System.out.print( "B " );
                    } else if( cell == GameElement.END.getCode() ) {

                        System.out.print( "()" );
                    }
                }
            }
            System.out.println();
        }
        System.out.println( "========================================================================================");
    }

    static void congrats(int lvl) {

        System.out.println( "Congratulations, Level " + lvl + " is passed!!!" );
        System.out.println( "========================================================================================");
        System.out.println( "Start next level? Print y/n" );
    }


    static void printLvlLoad(int lvl) {

        System.out.println( "Level " + lvl + " is ready! Good luck and have fun!");
        System.out.println( "========================================================================================");
    }

    static void printFail(GameElement failedElement) {

        if( failedElement == GameElement.OBSTACLE ) {

            System.out.println( "Unfortunately you crashed into an obstacle and lost...");
        } else {

            System.out.println( "A color in your command mismatches a color of cell (" + failedElement.name() + ")... Be more attentive next time.");
        }
        System.out.println( "========================================================================================");
        System.out.println( "Start new game? Print y/n" );
    }

    static void printBye() {

        System.out.println( "Bye..." );
    }

    static void printEnd() {

        System.out.println( "Congratulations, you win!!!" );
        System.out.println( "Start new game? Print y/n" );
    }
}
