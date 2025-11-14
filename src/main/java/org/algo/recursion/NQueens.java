package org.algo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */
public class NQueens {

    public static void main(String[] args) {
        System.out.println(NQueens.find(3));
    }

    public static List<List<Integer>> find(int n){
        List<List<Integer>> results = new ArrayList<>();
         findAllPositionsOfNQueens(0, n,new ArrayList<>(),  results);
        return results;
    }

    public static void findAllPositionsOfNQueens(int row, int n,  List<Integer> positions, List<List<Integer>> results){

        if(row == n){
            results.add(new ArrayList<>(positions));
            //positions.clear();
            return;

        }

            for (int c = 0; c < n; c++) {
               positions.add(c);
                if (isValid(positions)) {
               // if (isValid(row, c,positions)) {

                   positions.add(c);
                    findAllPositionsOfNQueens(row + 1, n, positions, results);
                }

                positions.remove(positions.size()-1);
            }


    }

   // private static boolean isValid( List<Integer> positions){
    private static boolean isValid( int r, int c, List<Integer> positions){
        //int r = positions.size() -1;
        for(int i =0; i < r ; i++){
            int validColumn = positions.get(i);
           // int diff = Math.abs(validColumn-positions.get(r));
            int diff = Math.abs(validColumn-c);
            if(diff == 0 || r-i == diff){
                return false;
            }
        }

        return true;
    }

}
