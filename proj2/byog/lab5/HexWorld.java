package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    private static int maxRow;
    private static int maxCol;
    private static int xPos;
    private static int yPos;

    /** determine the size of all hexagons. */
    public static void addHexagon(int size) {
        maxRow = size;
        maxCol = size;
        xPos = 30;
        yPos = 30;
    }

    /** draw the left half of the hexagon. */
    private static void drawLeftHalf(TETile[][] tiles, int maxRow, int maxCol, int xPos, int yPos) {
        int count = 1;
        int startXPos = xPos;
        for (int y = 0; y < maxRow; y += 1) {
            for (int x = 0; x < maxCol; x += 1) {
                tiles[yPos][xPos] = Tileset.FLOWER;
                xPos += 1;
            }
            yPos += 1;
            xPos = startXPos - count;
            count += 1;
            maxCol = maxCol + 2;
        }
    }

    /** draw the right half of the hexagon. */
    private static void drawRightHalf(TETile[][] tiles, int maxRow, int maxCol, int xPos, int yPos) {
        int count = 1;
        int startXPos = xPos;
        maxCol = maxCol+2*(maxCol-1);
        for (int y = 0; y < maxRow; y += 1) {
            for (int x = 0; x < maxCol; x += 1) {
                tiles[yPos][xPos] = Tileset.FLOWER;
                xPos += 1;
            }
            yPos += 1;
            xPos = startXPos + count;
            count += 1;
            maxCol = maxCol - 2;
        }
    }


    public static void main(String[] args) {

        //initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        //initialize tiles
        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                randomTiles[x][y] = Tileset.NOTHING;
            }
        }

        addHexagon(4);

        drawLeftHalf(randomTiles,maxRow, maxCol, xPos, yPos);
        drawRightHalf(randomTiles,maxRow, maxCol, xPos-maxRow+1,yPos+maxCol);



        //drawLeftHalf(randomTiles,3, 3, 30,30);
        //drawRightHalf(randomTiles,3, 3, 28,33);


        // draws the world to the screen
        ter.renderFrame(randomTiles);
    }




}
