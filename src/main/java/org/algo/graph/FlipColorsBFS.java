package org.algo.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlipColorsBFS {

    static List<List<Boolean>> maze = Arrays.asList(
            Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE),
            Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE),
            Arrays.asList(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE)
    );
    public static void main(String[] args) {
        FlipColorsBFS.flipColor(maze, new Coordinate(0,0));
        System.out.println(maze);
    }
    
    private static  class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void flipColor(List<List<Boolean>> maze, Coordinate src){

        boolean color = maze.get(src.x).get(src.y);
        Queue<Coordinate> queue = new LinkedList<>();
        maze.get(src.x).set(src.y, !color);
        queue.add(src);//queue.enque()
        int[][] DIRS = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){

            Coordinate cur = queue.element();//queue.pee()
            for(int[] dir : DIRS){
                Coordinate next = new Coordinate(cur.x+dir[0], cur.y+dir[1]);
                if(next.x >=0 && next.x< maze.size()&& next.y >=0 && next.y < maze.size()
                        && color == maze.get(next.x).get(next.y)){
                    maze.get(next.x).set(next.y,!color);
                    queue.add(next);
                }
            }
            queue.remove(); //queue.deque()
        }
    }
    
}
