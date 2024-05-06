package com.thoughtworks.msb.financialManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionIdTest {

    @Test
    void transactionsIdWithTheSameIdMustBeEqual() {
        Assertions.assertEquals(
                new TransactionId("3345"),
                new TransactionId("3345")
        );
    }

}