package com.zhdanko.transaction;

public interface TransactionExample {
    void withoutTransaction();
    @Transaction
    void withTransaction();
}
