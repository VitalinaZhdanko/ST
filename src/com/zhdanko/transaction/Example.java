package com.zhdanko.transaction;

public class Example implements TransactionExample {
    @Override
    public void withoutTransaction() {
        System.out.println("Method without transaction");
    }

    @Override
    @Transaction
    public void withTransaction() {
        System.out.println("Method with transaction");
    }

}

