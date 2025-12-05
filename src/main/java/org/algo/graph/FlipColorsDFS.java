package org.algo.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FlipColorsDFS {
    static List<List<Boolean>> maze = Arrays.asList(
            Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE),
            Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE),
            Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE)
    );

    public static class Coordinate {
        int r; // row
        int c; // column

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        flipColors(maze, new Coordinate(0, 0));
        System.out.println(maze);
    }

    public static void flipColors(List<List<Boolean>> maze, Coordinate cur) {
        int rows = maze.size();
        if (rows == 0) return;
        int cols = maze.get(0).size(); // assumes rectangular; otherwise check per-row when needed

        // original color at current cell
        Boolean original = maze.get(cur.r).get(cur.c);
        // flip current
        maze.get(cur.r).set(cur.c, !original);

        int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir : DIRS) {
            int nr = cur.r + dir[0];
            int nc = cur.c + dir[1];

            // correct bounds checks: row vs column
            if (nr >= 0 && nr < rows && nc >= 0 && nc < maze.get(nr).size()) {
                // compare neighbor's current color with the original color (use equals to compare Booleans)
                if (Objects.equals(maze.get(nr).get(nc), original)) {
                    flipColors(maze, new Coordinate(nr, nc));
                }
            }
        }
    }
}