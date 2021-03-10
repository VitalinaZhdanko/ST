package com.zhdanko;

import com.zhdanko.database.PaymentService;
import com.zhdanko.database.model.Payment;
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
import com.zhdanko.xml.OperationWithXml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.Point;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException {

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
        OperationWithString.concatString(str);
        long stopTime = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        OperationWithString.concatStringBuilder(str);
        long stopTime2 = System.currentTimeMillis();

        if (stopTime - startTime > stopTime2 - startTime2) {
            System.out.println("speed with help String is higher, than speed with help StringBuilder");
        } else {
            System.out.println("speed with help String is less, than speed with help StringBuilder");
        }

        // Task 9
        String strHex = "0xFF aaaa0xFF 0xFFgg";
        OperationWithString.findHex(strHex);

        // Task 10
        String strTags = "<p> <p id=p1> tags tag";
        OperationWithString.findTags(strTags);

        // Task 11
        double number = 153.99;
        System.out.printf("%d рубля %d копеек", (int) number, (int) ((number - (int) number) * 100));
        System.out.println();

        // Task 12
        System.out.println(Locale.getDefault());
        ResourceBundle bundleDefault = ResourceBundle.getBundle("com.zhdanko.resources.resource");
        ResourceBundle bundleBy = ResourceBundle.getBundle("com.zhdanko.resources.resource", new Locale("be", "BY"));
        ResourceBundle bundleRu = ResourceBundle.getBundle("com.zhdanko.resources.resource", new Locale("ru", "Ru"));

        System.out.println(bundleDefault.getString("greeting"));
        System.out.println(bundleBy.getString("greeting"));
        System.out.println(bundleRu.getString("greeting"));

        // Task 13
        PaymentService paymentService = new PaymentService();

        String queryGetBy = "select name, code, payment_data, amount from payment join recipient r on r.id = payment.recipient_id where amount > 10000";
        paymentService.getPayments(queryGetBy);

        // Task 14
        paymentService.createPayments();
        String queryGetAll = "select name, code, payment_data, amount from payment join recipient r on r.id = payment.recipient_id";
        paymentService.getPayments(queryGetAll);

        // Task 15
        Payment payment = new Payment(20, 300, new Date(), 1);
        paymentService.createPaymentsPrepStat(payment);
        paymentService.getPayments(queryGetAll);

        // Task 16
        OperationWithXml.createXml("test.xml");

        // Task 18
        OperationWithXml.printXml("test.xml");

        // Task 19
        OperationWithXml.createHtml("test.xml", "test.xslt", "test.html");
    }
}
