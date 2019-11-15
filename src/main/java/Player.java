public class Player implements Movable {

    private int x, y;
    private EyeDirection eyeDirection;
    private boolean isAlive;

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    boolean isAlive() {
        return isAlive;
    }

    void setAlive(boolean alive) {
        isAlive = alive;
    }

    public EyeDirection getEyeDirection() {
        return eyeDirection;
    }

    void setEyeDirection(EyeDirection eyeDirection) {
        this.eyeDirection = eyeDirection;
    }

    private void updateX(int dx) {

        x += dx;
    }

    private void updateY(int dy) {

        y += dy;
    }

    void refresh() {

        isAlive = true;
        eyeDirection = EyeDirection.EAST;
    }

    @Override
    public void move( Movement movement ) {

        switch ( movement ) {

            case LEFT: {

                switch ( eyeDirection ) {

                    case EAST: {

                        eyeDirection = EyeDirection.NORTH;
                        break;
                    }

                    case NORTH: {

                        eyeDirection = EyeDirection.WEST;
                        break;
                    }

                    case WEST: {

                        eyeDirection = EyeDirection.SOUTH;
                        break;
                    }

                    case SOUTH: {

                        eyeDirection = EyeDirection.EAST;
                        break;
                    }
                }
                break;
            }

            case RIGHT: {

                switch ( eyeDirection ) {

                    case EAST: {

                        eyeDirection = EyeDirection.SOUTH;
                        break;
                    }

                    case SOUTH: {

                        eyeDirection = EyeDirection.WEST;
                        break;
                    }

                    case WEST: {

                        eyeDirection = EyeDirection.NORTH;
                        break;
                    }

                    case NORTH: {

                        eyeDirection = EyeDirection.EAST;
                        break;
                    }
                }
                break;
            }

            case FORWARD: {

                switch ( eyeDirection ) {

                    case NORTH: {

                        updateY( -1 );
                        break;
                    }

                    case EAST: {

                        updateX( 1 );
                        break;
                    }

                    case SOUTH: {

                        updateY( 1 );
                        break;
                    }

                    case WEST: {

                        updateX( -1 );
                    }
                }
                break;
            }
        }
    }

    void print() {

        switch ( eyeDirection ) {

            case NORTH: {

                System.out.print( "^ " );
                break;
            }

            case EAST: {

                System.out.print( "> " );
                break;
            }

            case SOUTH: {

                System.out.print( "v " );
                break;
            }

            case WEST: {

                System.out.print( "< " );
                break;
            }
        }
    }
}
