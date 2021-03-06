package com.tdebroc.myapp.filler.game;

import java.io.Serializable;

public class Position implements Serializable {

    private int x;

    private int y;

    public Position() {

    }
    public Position(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int hashCode() {
        return (x * 31) ^ y;
    }

    public boolean equals(Object o) {
        if (o instanceof Position) {
            Position other = (Position) o;
            return (x == other.x && y == other.y);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Position{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
}
