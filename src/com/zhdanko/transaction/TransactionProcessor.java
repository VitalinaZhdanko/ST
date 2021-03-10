package com.zhdanko.transaction;

import java.lang.reflect.Proxy;

public class TransactionProcessor {
    public Object processTransactionAnnotation(final Object obj) {
        final Class<?> aClass = obj.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), (proxy, method, args) -> {
            if (method.isAnnotationPresent(Transaction.class)) {
                System.out.println("Transaction is started");
                final Object returnValue = method.invoke(obj, args);
                System.out.println("Transaction is ended");
                return returnValue;
            }
            return method.invoke(obj, args);
        });
    }
}

