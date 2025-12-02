package org.algo.recursion;

import java.util.List;
import java.util.Objects;

public record Move( int ringNum,int fromPeg, int toPeg ) {
    @Override
    public String toString() {
        return "Move{" +
                 ringNum +
                ", p" + fromPeg +
                ", p" + toPeg +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return toPeg() == move.toPeg() && ringNum() == move.ringNum() && fromPeg() == move.fromPeg();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ringNum(), fromPeg(), toPeg());
    }
}
