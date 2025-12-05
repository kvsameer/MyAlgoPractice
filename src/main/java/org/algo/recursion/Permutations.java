package org.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(Permutations.permutations(Arrays.asList(1,2,3)));
    }

    public static List<List<Integer>> permutations(List<Integer> ints){
        List<List<Integer>>  result = new ArrayList<>();
        permutations(ints,0, result);
        return result;
    }

    public static void permutations(List<Integer> ints, int pos, List<List<Integer>> result){
        if(pos == ints.size()){
            result.add(new ArrayList<>(ints));
            return;
        }

        for(int i=pos; i < ints.size() ; i++){
            Collections.swap(ints, pos,i);
            permutations(ints,pos+1, result);
            Collections.swap(ints,pos,i);
        }
    }
}
