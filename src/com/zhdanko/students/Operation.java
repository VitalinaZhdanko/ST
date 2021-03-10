package com.zhdanko.students;

import java.util.ArrayList;
import java.util.ListIterator;

public class Operation {
    public static void fillList(ArrayList<Integer> mark, int count) {
        for (int i = 0; i < count; i++) {
            mark.add(i, (int) (Math.random() * 10 + 1));
        }
    }

    public static void removeBadMark(ArrayList<Integer> mark, int badMark) {
        ListIterator<Integer> iterator = mark.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next() < badMark) {
                iterator.remove();
            }
        }
        // mark.removeIf(m -> m < badMark);
    }

    public static int goodMark(ArrayList<Integer> mark) {
        int goodMark = 0;
        ListIterator<Integer> iterator = mark.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next() > goodMark) {
                goodMark = iterator.previous();
            }
        }
        return goodMark;
    }
}
