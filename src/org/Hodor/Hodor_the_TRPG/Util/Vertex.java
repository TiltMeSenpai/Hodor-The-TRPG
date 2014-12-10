package org.Hodor.Hodor_the_TRPG.Util;

import org.Hodor.Hodor_the_TRPG.Delegate;
import org.Hodor.Hodor_the_TRPG.Model.Map.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Vertex implements Comparable<Vertex>{
    int x, y, points;
    ArrayList<Vertex> edges;
    public static java.util.Map<String, Vertex> vertices = new ConcurrentHashMap<String, Vertex>();
    public static java.util.Map<Vertex, Vertex> cameFrom = new HashMap<Vertex, Vertex>();

    public Vertex(int x, int y){
        this.x = x;
        this.y = y;
        edges = new ArrayList<Vertex>();
    }

    public Vertex(int x, int y, int points){ // Create node with allowed moves left
        this.x = x;
        this.y = y;
        this.points = points;
        vertices.put(x + ", " + y, this);
        edges = new ArrayList<Vertex>();
    }

    public synchronized Vertex generate(Map map, int maxV){ // Recursive depth-first search to find all possible moves
        this.edges.clear();
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
            if(dir[0] >= 0 && dir[1] >= 0 && dir[0] < Delegate.getMap().getMap().length
                    && dir[1] < Delegate.getMap().getMap().length){
                String coords = dir[0]+", "+dir[1];
                int dH = Math.abs(map.get(dir[0], dir[1]).getHeight()-h);
                if(points - dH - 1 >= 0 && dH <= maxV && Delegate.getController().getUnit(dir[0], dir[1]) == null) {
                    if (!vertices.containsKey(coords)) {
                        Vertex newV = new Vertex(dir[0], dir[1], points - dH - 1);
                        edges.add(newV.generate(map, maxV));
                        cameFrom.put(newV, this);
                    }
                    else if (vertices.get(coords).points < points - dH - 1) {
                        vertices.get(coords).points = points - dH - 1;
                        edges.add(vertices.get(coords));
                        cameFrom.put(vertices.get(coords), this);
                    }
                }
            }
        }
        return this;
    }

    public synchronized void destroy() {
        if(vertices.size() != 0)
            vertices.clear();
        for(Vertex child : edges)
            child.destroy();
        points = 0;
        edges.clear();
    }

    public static boolean isValidMove(String move){
        return cameFrom != null && vertices != null &&
                vertices.containsKey(move) &&
                cameFrom.containsKey(vertices.get(move));
    }

    public static ArrayList<Vertex> reconstructPath(Vertex goal){
        ArrayList<Vertex> totalPath = new ArrayList<Vertex>();
        totalPath.add(goal);
        while(cameFrom.containsKey(goal)){
            goal = cameFrom.get(goal);
            totalPath.add(goal);
        }
        Collections.reverse(totalPath);
        return totalPath;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return " "+points+": ("+x+", "+y+")";
    }

    @Override
    public int compareTo(Vertex vertex) {
        return Integer.compare(this.points, vertex.points);
    }
}
