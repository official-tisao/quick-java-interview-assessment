package com.assessment.saheed.controllers;

import com.assessment.saheed.models.Statistics;
import com.assessment.saheed.models.Transaction;
import com.assessment.saheed.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.format.DateTimeParseException;

@RestController
@RequiredArgsConstructor
public class TransactionController {

        private final TransactionService transactionService;

        @PostMapping("/transactions")
        public ResponseEntity<Void> addTransaction(@RequestBody Transaction transaction) {
            try {
                transaction.setAmount(transaction.getAmount().setScale( 2, BigDecimal.ROUND_HALF_UP));
                Instant now = Instant.now();
                Instant transactionTime = transaction.getTimestamp();

                if (transactionTime.isAfter(now)) {
                    return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
                }

                if (transactionTime.isBefore(now.minusSeconds(30))) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                if (transactionService.addTransaction(transaction)) return new ResponseEntity<>(HttpStatus.CREATED);
                else return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);

            } catch (DateTimeParseException e) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        @GetMapping("/transactions")
        public ResponseEntity<Statistics> getStatistics() {
            return ResponseEntity.ok(transactionService.getStatistics());
        }

        @DeleteMapping("/transactions")
        public ResponseEntity<Void> deleteTransactions() {
            transactionService.deleteTransactions();
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/statistics")
        public ResponseEntity<Statistics> statistics() {
            return ResponseEntity.ok(transactionService.getStatistics());
        }
    }
