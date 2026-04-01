package com.github.kevinnowak.java.java_language_specification.classes.enum_classes.example_enums;

import java.math.BigDecimal;
import java.util.EnumSet;

public class PaymentService {

    static void main() {
        BigDecimal purchaseAmount = new BigDecimal("1000.00");

        System.out.println("--- Processing Operations ---");

        for (PaymentMethod method : PaymentMethod.values()) {
            System.out.println(method.processTransaction(purchaseAmount));

            if (method.requiresAdditionalVerification(purchaseAmount)) {
                System.out.println(" -> Alert: Additional verification required for this transaction.");
            }
        }

        System.out.println("\n--- Static Lookup ---");
        PaymentMethod apiInput = PaymentMethod.fromString("credit card");
        System.out.println("API Input parsed as: " + apiInput.name());

        System.out.println("\n--- EnumSet Usage ---");
        EnumSet<PaymentMethod> instantMethods = EnumSet.of(PaymentMethod.CREDIT_CARD, PaymentMethod.PAYPAL);
        instantMethods.forEach(m -> System.out.println(" - " + m.getDisplayName()));
    }
}
