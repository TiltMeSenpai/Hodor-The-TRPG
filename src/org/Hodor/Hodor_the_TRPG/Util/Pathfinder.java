package org.Hodor.Hodor_the_TRPG.Util;

import org.Hodor.Hodor_the_TRPG.Delegate;

import java.util.*;

/**
 * Created by jkoike on 12/1/14.
 */
public class Pathfinder {
    int x, y;
    Vertex start;
    PriorityQueue<Vertex> open, closed;

    public Pathfinder(int x, int y, Vertex start) {
        this.x = x;
        this.y = y;
        this.start = start;
        open = new PriorityQueue<Vertex>(10, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex vertex, Vertex vertex2) {
                return Integer.compare(heuristic(vertex2)+vertex2.points, heuristic(vertex)+vertex.points);
            }
        });
        open.add(start);
        closed = new PriorityQueue<Vertex>();
    }

    private void resetPoints(Vertex head){
        head.points = Integer.MAX_VALUE;
        for(Vertex neighbor : head.edges)
            resetPoints(neighbor);
    }

    public ArrayList<Vertex> run(){
        resetPoints(start);
        Set<Vertex> closedSet = new HashSet<Vertex>();
        HashMap<Vertex, Integer> gScore = new HashMap<Vertex, Integer>();
        HashMap<Vertex, Vertex> cameFrom = new HashMap<Vertex, Vertex>();
        gScore.put(start, 0);
        start.points = heuristic(start);
        while(open.size() > 0){
            Vertex current = open.poll();
            if(current.x == x && current.y == y)
                return reconstructPath(cameFrom, current);
            closedSet.add(current);
            for(Vertex neighbor : current.edges){
                if(closedSet.contains(neighbor))
                    continue;
                int tGScore = gScore.get(current)+(Math.abs(Delegate.getMap().get(current.x, current.y).getHeight()
                        - Delegate.getMap().get(neighbor.x, current.y).getHeight())+1);
                if(!open.contains(neighbor) || (gScore.containsKey(neighbor) && (tGScore < gScore.get(neighbor)))){
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tGScore);
                    neighbor.points = tGScore + heuristic(neighbor);
                    if(!open.contains(neighbor))
                        open.add(neighbor);
                }
            }
        }
        return null; // There is no path to the goal.
    }

    public ArrayList<Vertex> reconstructPath(HashMap<Vertex, Vertex> cameFrom, Vertex goal){
        ArrayList<Vertex> totalPath = new ArrayList<Vertex>();
        while(cameFrom.containsKey(goal)){
            goal = cameFrom.get(goal);
            totalPath.add(goal);
        }
        Collections.reverse(totalPath);
        return totalPath;
    }

    public int heuristic(Vertex point){
        int dx1 = point.x - x,
            dy1 = point.y - y,
            dx2 = start.x - x,
            dy2 = start.y - y;
        return Math.abs(dx1*dy2 - dx2*dy1);
    }
}
