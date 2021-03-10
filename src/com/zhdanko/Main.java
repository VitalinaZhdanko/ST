package com.zhdanko;

import com.zhdanko.equipment.Fridge;
import com.zhdanko.equipment.GasStove;
import com.zhdanko.equipment.PlugIn;
import com.zhdanko.file.OperationWithFile;
import com.zhdanko.line.Line;
import com.zhdanko.strings.OperationWithString;
import com.zhdanko.students.OperationWithStudent;
import com.zhdanko.transaction.Example;
import com.zhdanko.transaction.TransactionExample;
import com.zhdanko.transaction.TransactionProcessor;

import java.awt.Point;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

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
        OperationWithStudent.fillList(markListFirst, 10);
        System.out.println(markListFirst);
        OperationWithStudent.removeBadMark(markListFirst, 4);
        System.out.println(markListFirst);

        // Task 4
        ArrayList<Integer> markListSecond = new ArrayList<>();
        OperationWithStudent.fillList(markListSecond, 12);
        System.out.println(markListSecond);
        System.out.println(OperationWithStudent.goodMark(markListSecond));

        // Task 5
        Fridge fridge = new Fridge("Fridge");
        System.out.println(fridge.toString());
        fridge.plugIn();
        GasStove gasStove = new GasStove("Gas stove");
        System.out.println(gasStove.toString());
        gasStove.plugIn();
        PlugIn mm = new Fridge("mm");
        mm.plugIn();

        // Task 6
        OperationWithFile.writeToFile("fileNumbers.txt");
        OperationWithFile.printNumbers("fileNumbers.txt");
        System.out.println(OperationWithFile.average("fileNumbers.txt"));

        // Task 7
        OperationWithFile.printFiles("/Users/vitalina_zhdanko/Documents/Work");

        // Task 8
        String str = "la";
        long startTime = System.currentTimeMillis();
        OperationWithString.ConcatString(str);
        long stopTime = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        OperationWithString.ConcatStringBuilder(str);
        long stopTime2 = System.currentTimeMillis();

        if (stopTime - startTime > stopTime2 - startTime2) {
            System.out.println("speed with help String is higher, than speed with help StringBuilder");
        } else {
            System.out.println("speed with help String is less, than speed with help StringBuilder");
        }

        // Task 9
        String strHex = "0xFF aaaa0xFF 0xFFgg";
        OperationWithString.FindHex(strHex);

        // Task 10
        String strTags = "<p> <p id=p1> tags tag";
        OperationWithString.FindTags(strTags);

        // Task 11
        double number = 153.99;
        System.out.printf("%d рубля %d копеек", (int) number, (int) ((number - (int) number) * 100));
        System.out.println();

    }
}
