package com.github.kevinnowak.java.java_language_specification.classes.enum_classes.example_enums;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

enum PaymentMethod implements TransactionProcessor {

    CREDIT_CARD("Credit Card", new BigDecimal("0.029"), new BigDecimal("0.30")) {
        @Override
        public String processTransaction(BigDecimal amount) {
            BigDecimal fee = calculateFee(amount);

            return "Processing " + getDisplayName() + " charge of $" + amount.add(fee).setScale(2, RoundingMode.CEILING) + " (Includes $" + fee.setScale(2, RoundingMode.CEILING) + " fee)";
        }

        @Override
        boolean requiresAdditionalVerification(BigDecimal amount) {
            return amount.compareTo(new BigDecimal("500.00")) > 0;
        }
    },
    PAYPAL("PayPal", new BigDecimal("0.034"), new BigDecimal("0.30")) {
        @Override
        public String processTransaction(BigDecimal amount) {
            return "Redirecting to PayPal portal for authorization of $" + amount.setScale(2, RoundingMode.CEILING);
        }

        @Override
        boolean requiresAdditionalVerification(BigDecimal amount) {
            return false; // PayPal handles its own verification off-site
        }
    },
    BANK_TRANSFER("Wire Transfer", new BigDecimal("0.00"), new BigDecimal("15.00")) {
        @Override
        public String processTransaction(BigDecimal amount) {
            return "Generating routing instructions for a Wire Transfer of $" + amount.setScale(2, RoundingMode.CEILING);
        }

        @Override
        boolean requiresAdditionalVerification(BigDecimal amount) {
            // Wire transfers always require manual compliance checks
            return true;
        }
    };

    private final String displayName;
    private final BigDecimal percentageFee;
    private final BigDecimal flatFee;

    private static final Map<String, PaymentMethod> LOOKUP_MAP;

    static {
        Map<String, PaymentMethod> map = new HashMap<>();

        for (PaymentMethod method : values()) {
            map.put(method.getDisplayName().toLowerCase(), method);
        }

        LOOKUP_MAP = Collections.unmodifiableMap(map);
    }

    PaymentMethod(String displayName, BigDecimal percentageFee, BigDecimal flatFee) {
        this.displayName = displayName;
        this.percentageFee = percentageFee;
        this.flatFee = flatFee;
    }

    abstract boolean requiresAdditionalVerification(BigDecimal amount);

    String getDisplayName() {
        return displayName;
    }

    BigDecimal calculateFee(BigDecimal amount) {
        return amount.multiply(percentageFee).add(flatFee);
    }

    static PaymentMethod fromString(String name) {
        PaymentMethod method = LOOKUP_MAP.get(name != null ? name.toLowerCase() : "");

        if (method == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + name);
        }

        return method;
    }
}
