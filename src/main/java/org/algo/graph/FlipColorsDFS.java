package org.algo.graph;

import java.util.Arrays;
import java.util.List;

public class FlipColorsDFS {
    static List<List<Boolean>> maze = Arrays.asList(
            Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE),
            Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE),
            Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE)
    );

    public static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        FlipColorsDFS.flipColors(maze, new Coordinate(0,0));
        System.out.println(maze);
    }

    public static void flipColors(List<List<Boolean>> maze, Coordinate cur){

        Boolean color = maze.get(cur.x).get(cur.y);
        maze.get(cur.x).set(cur.y, !color);
        int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir : DIRS) {
            Coordinate next = new Coordinate(cur.x+ dir[0], cur.y+dir[1]);
            if(next.y >=0 && next.y < maze.size() && next.y >= 0 && next.x >= 0 &&
                    next.x < maze.get(next.y).size() && color == maze.get(next.x).get(next.y)){
                flipColors(maze,next);
            }
        }

    }
}
