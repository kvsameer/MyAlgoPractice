package org.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 *Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C) and N disks. Initially, all the disks are stacked in decreasing value of diameter i.e., the smallest disk is placed on the top and they are on rod A. The objective of the puzzle is to move the entire stack to another rod (here considered C), obeying the following simple rules:
 * Only one disk can be moved at a time.
 * Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * No disk may be placed on top of a smaller disk.
 */
public class TowerOfHanoi {

    public static Peg p1 ;
    public static Peg p2 ;

    public static Peg p3 ;

    public static  void main(String[] args) {
        System.out.println(move(3));
    }

    public static List<Move> move(int numberOfRings){
        List<Integer> p1List = new ArrayList<>();
        int  copynumberOfRings = numberOfRings;
        for (int r = 1; r <=numberOfRings; r++) p1List.add(r);
         p1 = new Peg(p1List,1);
         p2 = new Peg(new ArrayList<>(),2);

          p3 = new Peg(new ArrayList<>(),3);
        return move(numberOfRings, p1,p2);
    }

    public static List<Move>  move (int numberOfRings, Peg fromPeg, Peg toPeg){
        List<Move> moveList = new ArrayList<>();

        if( numberOfRings == 1){
            moveList.add(new Move(fromPeg.rings().get(0), fromPeg.pegId(), toPeg.pegId()));
            toPeg.rings().add(0,fromPeg.rings().get(0));
            fromPeg.rings().remove(0);
            
            return moveList;
        }

        Peg helperPeg = 6- fromPeg.pegId()- toPeg.pegId() == 1 ? p1 : 6- fromPeg.pegId()- toPeg.pegId() == 2 ? p2: p3;

        moveList.addAll(move(numberOfRings-1, fromPeg,helperPeg ));
        moveList.addAll(move(1, fromPeg,toPeg ));
        moveList.addAll(move(numberOfRings-1, helperPeg,toPeg));
        return moveList;
    }
}
