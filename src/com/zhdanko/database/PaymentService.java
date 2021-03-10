package com.zhdanko.database;

import com.zhdanko.database.model.Payment;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PaymentService {
    private final Connection connection;

    public PaymentService() {
        connection = Conn.GetConnection();
    }

    public void getPayments(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("name   code    payment date   amount");

            while (rs.next()) {
                String name = rs.getString("name");
                int code = rs.getInt("code");
                java.util.Date date = rs.getDate("payment_data");
                int amount = rs.getInt("amount");
                System.out.println(name + "  " + code + "   " + date + "   " + amount);
            }
            System.out.println();
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPayments() {
        try {
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("insert into payment (code, amount, payment_data, recipient_id) VALUE (19, 11111, '2020-11-12', 1);\n");
            System.out.printf("Added %d rows", rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPaymentsPrepStat(Payment payment) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into payment (code, amount, payment_data, recipient_id) values (?, ?, ?, ? )");
            preparedStatement.setInt(1, payment.getCode());
            preparedStatement.setInt(2, payment.getAmount());
            preparedStatement.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
            preparedStatement.setInt(4, payment.getRecipientId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
