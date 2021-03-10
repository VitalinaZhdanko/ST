package com.zhdanko.line;


import java.awt.Point;
import java.awt.Color;

public class Line {
    private final Point begin;
    private final Point end;
    private final Color color;
    private final double thickness;

    public Line(Point begin, Point end, Color color, double thickness) {
        this.begin = begin;
        this.end = end;
        this.color = color;

        this.thickness = thickness;
    }

    public double getLength(){
        return Math.sqrt(Math.pow((end.x - begin.x), 2) + Math.pow((end.y - begin.x), 2));
    }

    @Override
    public String toString() {
        return "Line{" +
                "begin=" + begin.x + begin.y +
                ", end=" + end.x + + end.y +
                ", color=" + color.toString() +
                ", thickness=" + thickness +
                '}';
    }

}

