package org.Hodor.Hodor_the_TRPG.Util;

import java.util.Random;

/**
 * Created by jkoike on 11/5/14.
 */
public class MapGenerator {
    // 2d array representing the map. (0,0) is the top left corner. Coordinates are in (x, y),
    //      where y is the vertical axis.
    int[][] map;
    Random random;
    public MapGenerator(int size){
        map = new int[size][size];
        random = new Random();
    }

    private synchronized void linearInterpolate(int topX, int topY, int h, int w, float var){
        if(h < 2 || w < 2) return;
        int tL = map[topX][topY];
        int bL = map[topX][topY + h];
        int tR = map[topX + w][topY];
        int bR = map[topX + w][topY + h];
        int variance;
        {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i : new int[]{tL, bL, tR, bR}){
                max = (i > max)?i:max;
                min = (i < min)?i:min;
            }
            variance = (int)Math.abs((max - min) * var);
            System.out.println(variance);
        }
        map[topX + (w/2)][topY] = (tL + tR)/2;
        map[topX][topY + (h/2)] = (bL + tL)/2;
        map[topX + (w/2)][topY + (h/2)] = (tR + bR + bL + tL)/4 + ((variance!=0)?random.nextInt((variance*2))-(variance):0);
        map[topX + w][topY + (h/2)] = (tR + bR)/2;
        map[topX + (w/2)][topY + h] = (bR + bL)/2;

        linearInterpolate(topX, topY, h/2, w/2, var); // Top left corner
        linearInterpolate(topX + (w/2), topY, h/2, w/2, var); // Top right corner
        linearInterpolate(topX, topY + (h/2), h/2, w/2, var); // Bottom left corner
        linearInterpolate(topX + (w/2), topY + (h/2), h/2, w/2, var); //Bottom right corner
    }

    public int[][] generate() {
        map[0][0] = random.nextInt(20);
        map[map.length-1][0] = random.nextInt(20);
        map[0][map[0].length-1] = random.nextInt(20);
        map[map.length-1][map[0].length-1] = random.nextInt(20);
        linearInterpolate(0,0,map[0].length - 1, map.length - 1, .5f);
        return map;
    }

    public static void main(String[] args) {
        for(int[] row : new MapGenerator(17).generate()){
            for(int i : row){
                System.out.printf("%4d", i);
            }
            System.out.println();
        }
    }
}
