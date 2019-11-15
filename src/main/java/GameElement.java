public enum GameElement {

    START( 0 ),
    OBSTACLE( 1 ),
    RED( 2 ),
    GREEN( 3 ),
    BLUE( 4 ),
    EMPTY( 5 ),
    END( 9 );

    private int code;

    GameElement(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static GameElement getElementByCode( int code ) {

        switch ( code ) {

            case 0: {

                return START;
            }

            case 1: {

                return OBSTACLE;
            }

            case 2: {

                return RED;
            }

            case 3: {

                return GREEN;
            }

            case 4: {

                return BLUE;
            }

            case 5: {

                return EMPTY;
            }

            case 9: {

                return END;
            }

            default: {

                return null;
            }
        }
    }
}
