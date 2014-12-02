package org.Hodor.Hodor_the_TRPG.Util;

import android.util.Log;
import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;

import java.util.ArrayList;

public class Vertex {
    int x, y, points;
    ArrayList<Vertex> edges;
    public Vertex(int x, int y, int points){
        Log.i("New Vertex", "("+x+", "+y+")");
        this.x = x;
        this.y = y;
        this.points = points;
        Delegate.getMap().getVertices().put(x+", "+y, this);
        edges = new ArrayList<Vertex>();
    }
    public Vertex generate(Map map, int maxV){
        this.edges = new ArrayList<Vertex>();
        if(points < 1)
            return this;
        int[][] dirs = new int[][]{
                {x-1, y},
                {x+1, y},
                {x, y-1},
                {x, y+1}
        };
        int h = map.get(x,y).getHeight();
        for (int[] dir : dirs){
            if(dir[0] >= 0 && dir[1] >= 0){
                String coords = dir[0]+","+dir[1];
                int dH = Math.abs(map.get(dir[0], dir[1]).getHeight()-h);
                if(points - dH - 1 > 0) {
                    if (!map.getVertices().containsKey(coords))
                        edges.add(new Vertex(dir[0], dir[1], points - dH - 1).generate(map, maxV));
                    else if (map.getVertices().get(coords).points < points - dH - 1) {
                        map.getVertices().get(coords).points = points - dH - 1;
                        edges.add(map.getVertices().get(coords));
                    }
                }
            }
        }
        return this;
    }

    @Override
    public String toString() {
        String others = "";
        for(Vertex vertex : edges)
            others += ", "+vertex.toString();
        return points+": ("+x+", "+y+")"+others;
    }
}
