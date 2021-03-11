package com.zhdanko.finalTask.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Park {
    private final List<ParkItem>  parkItemList;
    private int count;
    private int cost;

    public Park() {
        parkItemList = new ArrayList<>();
        count = 0;
        cost = 0;
    }

    public int getCount() {
        return count;
    }

    public int getCost() {
        return cost;
    }

    public void addTree(final TreeKind kind, final Point point) {
        boolean isNotExist = parkItemList.stream().noneMatch(item -> item.getLocation().equals(point));
        if (isNotExist) {
            ParkItem parkItem = new ParkItem();

            parkItem.setKind(kind);
            parkItem.setLocation(point);

            parkItemList.add(parkItem);

            incrementCount();
            incrementCost(kind);

            System.out.println(kind.getSort() + " planted");
        } else {
            System.out.println("seat occupied");
        }
    }

    public void incrementCount() {
        count++;
    }

    public void incrementCost(final TreeKind kind) {
        cost += kind.getPrice();
    }


}
