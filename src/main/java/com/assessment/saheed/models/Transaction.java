package com.assessment.saheed.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private BigDecimal amount;
    private Instant timestamp;
}
