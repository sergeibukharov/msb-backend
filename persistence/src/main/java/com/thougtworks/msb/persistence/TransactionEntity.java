package com.thougtworks.msb.persistence;

import jakarta.persistence.Entity;

import java.time.ZonedDateTime;

@Entity
public class TransactionEntity {
    public String TransactionId;
    public ZonedDateTime transactionAlliedDate;
}
