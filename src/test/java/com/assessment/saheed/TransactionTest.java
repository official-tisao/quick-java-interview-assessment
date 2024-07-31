package com.assessment.saheed;

import com.assessment.saheed.controllers.TransactionController;
import com.assessment.saheed.models.Transaction;
import com.assessment.saheed.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.lang.Void;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TransactionTest {

    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addTransaction_SuccessfulCreation() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("12.3343"));
        transaction.setTimestamp(Instant.now().minusSeconds(10)); // Within 30 seconds
        when(transactionService.addTransaction(transaction)).thenReturn(true);
        ResponseEntity<Void> response = transactionController.addTransaction(transaction);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(transactionService, times(1)).addTransaction(transaction);
    }

    @Test
    void addTransaction_TransactionOlderThan30Seconds() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("12.3343"));
        transaction.setTimestamp(Instant.now().minusSeconds(31)); // Older than 30 seconds
        when(transactionService.addTransaction(transaction)).thenReturn(false);
        ResponseEntity<Void> response = transactionController.addTransaction(transaction);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void addTransaction_InvalidJson() {
        // Simulate invalid JSON parsing error
        Transaction transaction = mock(Transaction.class);
        doThrow(new RuntimeException("Invalid JSON")).when(transaction).getAmount();
        ResponseEntity<Void> response = transactionController.addTransaction(transaction);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(transactionService, never()).addTransaction(any(Transaction.class));
    }

    @Test
    void addTransaction_UnparsableFieldsOrFutureTimestamp() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("12.3343"));
        transaction.setTimestamp(Instant.now().plusSeconds(10)); // Future timestamp
        ResponseEntity<Void> response = transactionController.addTransaction(transaction);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        verify(transactionService, never()).addTransaction(transaction);
    }

    @Test
    void addTransaction_NullTransaction() {
        ResponseEntity<Void> response = transactionController.addTransaction(null);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(transactionService, never()).addTransaction(any(Transaction.class));
    }

    @Test
    void addTransaction_EmptyAmount() {
        Transaction transaction = new Transaction();
        transaction.setAmount(null);
        transaction.setTimestamp(Instant.now().minusSeconds(10));
        ResponseEntity<Void> response = transactionController.addTransaction(transaction);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(transactionService, never()).addTransaction(transaction);
    }

    @Test
    void addTransaction_EmptyTimestamp() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("12.3343"));
        transaction.setTimestamp(null);
        ResponseEntity<Void> response = transactionController.addTransaction(transaction);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(transactionService, never()).addTransaction(transaction);
    }
}
