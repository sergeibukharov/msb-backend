package com.thoughtworks.msb.financialManagement;

import java.time.ZonedDateTime;

public class Transaction {
    public final TransactionId transactionId;
    public final ZonedDateTime TransactionAppliedDate;

    public Transaction(
            final TransactionId transactionId,
            final ZonedDateTime transactionAppliedDate
    ) {
        this.transactionId = transactionId;
        TransactionAppliedDate = transactionAppliedDate;
    }
}
