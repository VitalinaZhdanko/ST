package com.zhdanko.finalTask.model;

import java.awt.Point;

public class ParkItem {
    private Point location;
    private TreeKind kind;

    public TreeKind getKind() {
        return kind;
    }

    public void setKind(TreeKind kind) {
        this.kind = kind;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
