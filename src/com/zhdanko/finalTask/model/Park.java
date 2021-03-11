package com.zhdanko.finalTask.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Park {
    private List<ParkItem> parkItemList = new ArrayList<>();

    public List<ParkItem> getParkItemList() {
        return parkItemList;
    }

    public void setParkItemList(List<ParkItem> parkItemList) {
        this.parkItemList = parkItemList;
    }

    public void addTree(final TreeKind kind, final Point point) {
        boolean isNotExist = parkItemList.stream().noneMatch(item -> item.getLocation().equals(point));
        if (isNotExist) {
            ParkItem parkItem = new ParkItem();
            parkItem.setKind(kind);
            parkItem.setLocation(point);
            parkItemList.add(parkItem);
            System.out.println(kind.getSort() + " planted");
        } else {
            System.out.println("seat occupied");
        }
    }
}
