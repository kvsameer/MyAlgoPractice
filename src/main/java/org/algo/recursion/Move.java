package org.algo.recursion;

import java.util.List;

public record Move( int ringNum,int fromPeg, int toPeg ) {
    @Override
    public String toString() {
        return "Move{" +
                 ringNum +
                ", p" + fromPeg +
                ", p" + toPeg +
                '}';
    }
}
