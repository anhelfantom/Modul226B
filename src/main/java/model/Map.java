package model;

public class Map {

    private Integer[][] map2DArray;
    private Player player;

    public Map( Integer[][] map2DArray) {

        this.map2DArray = new Integer[ map2DArray.length ][ map2DArray[ 0 ].length ];
        for (int i = 0; i < map2DArray.length; i++) {

            for (int j = 0; j < map2DArray[ i ].length; j++) {

                this.map2DArray[ i ][ j ] = map2DArray[ i ][ j ];
            }
        }
    }

    public void setPlayer(Player player) {

        this.player = player;
        for (int i = 0; i < map2DArray.length; i++) {

            for (int j = 0; j < map2DArray[0].length; j++) {

                if( map2DArray[ i ][ j ] == 0 ) {

                    this.player.setX( j );
                    this.player.setY( i );
                }
            }
        }
    }

    public int getCurrentElement(Player player ) {

        return map2DArray[ player.getY() ][ player.getX() ];
    }

    public boolean isObstacle( int x, int y ) {

        try {

            return map2DArray[ y ][ x ] == 1;
        } catch ( ArrayIndexOutOfBoundsException e ) {

            return true;
        }
    }



    public boolean isFinished(int x, int y ) {

        return map2DArray[ y ][ x ] == 9;
    }

    public Integer[][] getMap2DArray() {
        return map2DArray;
    }
}
