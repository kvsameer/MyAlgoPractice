package org.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(Permutations.permutations(Arrays.asList(2,3,5)));
    }

    public static List<List<Integer>> permutations(List<Integer> ints){
        List<List<Integer>> results = new ArrayList<>();
        permutations(0, ints, results);
        return results;
    }

    public static void permutations(int i, List<Integer> ints,  List<List<Integer>> results){

        if(i == ints.size() -1){
            results.add(new ArrayList<>(ints));
        }
        else{
            for(int j = i; j < ints.size() ; j++){
                Collections.swap(ints, i , j);
                permutations(i+1, ints, results);
                Collections.swap(ints, i , j);
            }
        }
    }
}
