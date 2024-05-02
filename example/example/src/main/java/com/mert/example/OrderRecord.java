package com.mert.example;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
