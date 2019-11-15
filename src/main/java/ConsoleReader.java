

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ConsoleReader {

    private static Scanner scanner = new Scanner( System.in );

    static List<Action> readAction() {

        List<Action> actionList = new ArrayList<>();
        String command = null;
        boolean isCommandRight = false;

        while( !isCommandRight ) {

            while ( scanner.hasNextLine() && !( command = scanner.nextLine() ).equals( "end" ) ) {

                Movement direction = null;
                int element = -1;
                int repeat = -1;
                String[] cmmndParts = command.split( " " );
                if( cmmndParts.length >= 2 && cmmndParts.length <= 5 ) {

                    direction = parseDirection( cmmndParts[ 0 ], cmmndParts[ 1 ] );
                    element = 0;
                    repeat = 1;
                }
                if( cmmndParts.length == 3 || cmmndParts.length == 5 ) {

                    element = parseElement( cmmndParts[ 2 ] );
                }
                if( cmmndParts.length == 4 ) {

                    element = 0;
                    repeat = parseRepeat( cmmndParts[ 2 ], cmmndParts[ 3 ] );
                }
                if( cmmndParts.length == 5 ) {

                    repeat = parseRepeat( cmmndParts[ 3 ], cmmndParts[ 4 ] );
                }
                if( direction == null || element == -1 || repeat == -1 ) {

                    System.err.println( "Your command is not correct" );
                } else {

                    actionList.add( new Action( direction, element, repeat ) );
                    isCommandRight = true;
                }
            }
        }
        return actionList;
    }

    private static Movement parseDirection( String s1, String s2 ) {

        if( s1.equalsIgnoreCase( "move" ) ) {

            if( s2.equalsIgnoreCase( "forward" ) ) {

                return Movement.FORWARD;
            } else {

                return null;
            }
        } else if( s1.equalsIgnoreCase( "turn" ) ) {

            if( s2.equalsIgnoreCase( "left" ) ) {

                return Movement.LEFT;
            } else if( s2.equalsIgnoreCase( "right" ) ) {

                return Movement.RIGHT;
            } else {

                return null;
            }
        } else {

            return null;
        }
    }

    private static int parseElement(String s ) {

        if( s.equalsIgnoreCase( "red" ) ) {

            return GameElement.RED.getCode();
        } else if( s.equalsIgnoreCase( "green" ) ) {

            return GameElement.GREEN.getCode();
        } else if( s.equalsIgnoreCase( "blue" ) ) {

            return GameElement.BLUE.getCode();
        } else {

            return -1;
        }
    }

    private static int parseRepeat( String s1, String s2 ) {

        if( s1.equalsIgnoreCase( "repeat" ) ) {

            return Integer.parseInt( s2 );
        } else {

            return -1;
        }
    }

    static boolean chooseYN() {

        while( true ) {

            if( scanner.hasNextLine() ) {

                String response = scanner.nextLine();
                if ( response.equalsIgnoreCase( "y" ) ) {

                    return true;
                } else if ( response.equalsIgnoreCase( "n" ) ) {

                    return false;
                } else System.err.println( "Error. Print y/n" );
            }
        }
    }

    static boolean startNextLvl() {
        while ( true ) {

            if ( scanner.hasNextLine() ) {

                String response = scanner.nextLine();
                if ( response.equalsIgnoreCase( "y" ) ) {

                    return true;
                } else if ( response.equalsIgnoreCase( "n" ) ) {

                    return false;
                } else System.err.println( "Error. Print y/n" );
            }
        }
    }
}
