package org.algo.recursion;

import java.util.List;

public record Peg(List<Integer> rings, int pegId ) {

    @Override
    public String toString() {
        return "Peg{" +
                "rings=" + rings +
                ", pegId=" + pegId +
                '}';
    }
}
