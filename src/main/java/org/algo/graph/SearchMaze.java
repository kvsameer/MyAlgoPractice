package org.algo.graph;

import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SearchMaze {

    static List<List<Color>> maze = Arrays.asList(
           Arrays.asList(Color.WHITE, Color.WHITE, Color.WHITE),
            Arrays.asList(Color.WHITE, Color.BLACK, Color.WHITE),
            Arrays.asList(Color.WHITE, Color.WHITE, Color.WHITE)
    );

    //not used
    static Color[][] maze2 = {
            {Color.WHITE, Color.WHITE, Color.WHITE},
            {Color.WHITE, Color.WHITE, Color.WHITE},
            {Color.WHITE, Color.WHITE, Color.WHITE}
                   };

    public static void main(String[] args) {
        System.out.println(SearchMaze.searchMaze(maze, new Coordinate(0,0), new Coordinate(2,2) ));
    }

    public static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static enum Color {BLACK, WHITE}

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate src, Coordinate end){
        List<Coordinate> path = new ArrayList<>();
        searchMaze(maze, src,end,path);
        return path;
    }

    public static boolean searchMaze(List<List<Color>> maze, Coordinate cur, Coordinate end, List<Coordinate> path){

        if(cur.equals(end)){
            return true;
        }
        int[][] DIRS = {{0,1}, {0,-1}, {1, 0},{-1,0}};
        maze.get(cur.x).set(cur.y, Color.BLACK);
        for (int[] dir : DIRS) {
            Coordinate next = new Coordinate(cur.x + dir[0], cur.y + dir[1]);

            if (isFeasible(next, maze)) {
                path.add(next);
                 if(searchMaze(maze, next, end, path)){
                     return true;
                 }
                path.remove(path.size() - 1);
            }


        }
        return false;
    }

    public static boolean isFeasible(Coordinate potentialNext , List<List<Color>> maze){
        int x = potentialNext.x;
        int y = potentialNext.y;

        return x >= 0 && x < maze.get(x).size() && y >= 0 && y < maze.size() && maze.get(x).get(y)==Color.WHITE;
    }
}
