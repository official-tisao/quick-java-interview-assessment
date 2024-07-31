package com.assessment.saheed.services;

import com.assessment.saheed.models.Statistics;
import com.assessment.saheed.models.Transaction;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TransactionService {
    private static final long EXPIRATION_TIME = 30 * 1000; // 30 seconds
    private final ConcurrentLinkedQueue<Transaction> transactions = new ConcurrentLinkedQueue<>();
    private final AtomicLong count = new AtomicLong();
    private final Object lock = new Object();

    public boolean addTransaction(Transaction transaction) {
        Instant now = Instant.now();
        if (transaction.getTimestamp().isAfter(now.minusMillis(EXPIRATION_TIME))) {
            synchronized (lock) {
                transactions.add(transaction);
                count.incrementAndGet();
                return true;
            }
        } else return false;

    }

    public void deleteTransactions() {
        synchronized (lock) {
            transactions.clear();
            count.set(0);
        }
    }
    //this method create and return statistics object
    public Statistics getStatistics() {
        Instant now = Instant.now();
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal min = BigDecimal.ZERO;
        BigDecimal max = BigDecimal.ZERO;
        long validCount = 0;
        //locking this operation to make it thread safe
        synchronized (lock) {
            transactions.removeIf(transaction -> transaction.getTimestamp().isBefore(now.minusMillis(EXPIRATION_TIME)));
            for (Transaction transaction : transactions) {
                sum = sum.add(transaction.getAmount());
                min = min.equals(BigDecimal.ZERO)? transaction.getAmount() : min.min(transaction.getAmount());
                max = max.max(transaction.getAmount());
                validCount++;
            }
        }
        //calculating average amount
        BigDecimal avg = validCount == 0 ? BigDecimal.ZERO : sum.divide(BigDecimal.valueOf(validCount), 2, BigDecimal.ROUND_HALF_UP);

        return new Statistics(sum, avg, max, min, validCount);
    }
}

