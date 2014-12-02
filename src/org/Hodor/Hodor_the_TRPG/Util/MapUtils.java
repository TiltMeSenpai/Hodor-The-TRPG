package org.Hodor.Hodor_the_TRPG.Util;

import java.util.Random;

/**
 * Created by jkoike on 11/5/14.
 */
public class MapUtils {
    // 2d array representing the map. (0,0) is the top left corner. Coordinates are in (x, y),
    //      where y is the vertical axis.
    int[][] map;
    Random random;
    public MapUtils(int size){
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
        }
        map[topX + (w/2)][topY] = Math.abs((tL + tR)/2);
        map[topX][topY + (h/2)] = Math.abs((bL + tL)/2);
        map[topX + (w/2)][topY + (h/2)] = Math.abs((tR + bR + bL + tL)/4 +
                ((variance!=0)?random.nextInt((variance*2))-(variance):0));
        map[topX + w][topY + (h/2)] = Math.abs((tR + bR)/2);
        map[topX + (w/2)][topY + h] = Math.abs((bR + bL)/2);

        linearInterpolate(topX, topY, h/2, w/2, var); // Top left corner
        linearInterpolate(topX + (w/2), topY, h/2, w/2, var); // Top right corner
        linearInterpolate(topX, topY + (h/2), h/2, w/2, var); // Bottom left corner
        linearInterpolate(topX + (w/2), topY + (h/2), h/2, w/2, var); //Bottom right corner
    }

    public int[][] generate() {
        map[0][0] = random.nextInt(10);
        map[map.length-1][0] = random.nextInt(10);
        map[0][map[0].length-1] = random.nextInt(10);
        map[map.length-1][map[0].length-1] = random.nextInt(10);
        linearInterpolate(0,0,map[0].length - 1, map.length - 1, 1f);
        return map;
    }

    public static void main(String[] args) {
        for(int[] row : new MapUtils(17).generate()){
            for(int i : row){
                System.out.printf("%4d", i);
            }
            System.out.println();
        }
    }
    public static int rampRed(int r){
        r *= 100;
        if(r < 450)
            return (int)((r/450.0)*251 + (1 - r/450.0)*46)/2;
        else if(r < 700){
            r -= 450;
            return (int)((r/250.0)*224 + (1 - r/250.0)*251)/2;
        }
        else if(r < 875){
            r -= 875;
            return (int)((r/125.0)*200 + (1 - r/125.0)*224)/2;
        }
        else return 215;
    }
    public static int rampGreen(int r){
        r *= 100;
        if(r < 450)
            return (int)((r/450.0)*255 + (1 - r/450.0)*154)/2;
        else if(r < 700){
            r -= 450;
            return (int)((r/250.0)*108 + (1 - r/250.0)*255)/2;
        }
        else if(r < 875){
            r -= 875;
            return (int)((r/125.0)*55 + (1 - r/125.0)*108)/2;
        }
        else return 244;
    }
    public static int rampBlue(int r){
        r *= 100;
        if(r < 450)
            return (int)((r/450.0)*128 + (1 - r/450.0)*88)/2;
        else if(r < 700){
            r -= 450;
            return (int)((r/250.0)*31 + (1 - r/250.0)*128)/2;
        }
        else if(r < 875){
            r -= 875;
            return (int)((r/125.0)*55 + (1 - r/125.0)*31)/2;
        }
        else return 244;
    }
}
