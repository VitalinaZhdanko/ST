package com.zhdanko;

import com.zhdanko.line.Line;

import java.awt.Point;
import java.awt.Color;

public class Main {

    public static void main(String[] args) {

        // Task 1
        Line lineFirst = new Line(new Point(1, 1), new Point(3, 3), new Color(1, 1, 1), 2);
        System.out.println(lineFirst.toString());
        System.out.println(lineFirst.getLength());
    }
}
