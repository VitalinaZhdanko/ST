package com.zhdanko;

import com.zhdanko.equipment.Fridge;
import com.zhdanko.equipment.GasStove;
import com.zhdanko.equipment.PlugIn;
import com.zhdanko.line.Line;
import com.zhdanko.students.Operation;
import com.zhdanko.transaction.Example;
import com.zhdanko.transaction.Transaction;
import com.zhdanko.transaction.TransactionExample;
import com.zhdanko.transaction.TransactionProcessor;

import java.awt.Point;
import java.awt.Color;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Task 1
        Line lineFirst = new Line(new Point(1, 1), new Point(3, 3), new Color(1, 1, 1), 2);
        System.out.println(lineFirst.toString());
        System.out.println(lineFirst.getLength());

        // Task 2
        Example exampleObj = new Example();
        TransactionProcessor transactionProcessor = new TransactionProcessor();
        final Object object = transactionProcessor.processTransactionAnnotation(exampleObj);
        ((TransactionExample) object).withoutTransaction();
        ((TransactionExample) object).withTransaction();

        // Task 3
        ArrayList<Integer> markListFirst = new ArrayList<>();
        Operation.fillList(markListFirst, 10);
        System.out.println(markListFirst);
        Operation.removeBadMark(markListFirst, 4);
        System.out.println(markListFirst);

        // Task 4
        ArrayList<Integer> markListSecond = new ArrayList<>();
        Operation.fillList(markListSecond, 12);
        System.out.println(markListSecond);
        System.out.println(Operation.goodMark(markListSecond));

        // Task 5
        Fridge fridge = new Fridge("Fridge");
        System.out.println(fridge.toString());
        fridge.plugIn();
        GasStove gasStove = new GasStove("Gas stove");
        System.out.println(gasStove.toString());
        gasStove.plugIn();
        PlugIn mm = new Fridge("mm");
        mm.plugIn();



    }
}
