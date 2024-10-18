package com.java17.utilityprograms;


public class DebitCardValidatorAndMasker {

    // Method to validate a debit card number using the Luhn algorithm
    public static boolean validateDebitCard(String cardNumber) {
        // Remove all non-numeric characters (e.g., spaces, dashes)
        String sanitizedCardNumber = cardNumber.replaceAll("\\D", "");

        // Check if card number contains only digits and has a valid length (between 13 to 19 digits)
        if (!sanitizedCardNumber.matches("\\d{13,19}")) {
            return false;
        }

        // Luhn algorithm implementation
        int total = 0;
        boolean alternate = false;

        for (int i = sanitizedCardNumber.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(sanitizedCardNumber.substring(i, i + 1));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            total += digit;
            alternate = !alternate;
        }

        // Card is valid if the sum is divisible by 10
        return (total % 10 == 0);
    }

    // Method to securely mask the debit card number, showing only the last four digits
    public static String maskDebitCard(String cardNumber) {
        // Remove all non-numeric characters
        String sanitizedCardNumber = cardNumber.replaceAll("\\D", "");

        // Mask all but the last 4 digits
        int length = sanitizedCardNumber.length();
        if (length < 4) {
            throw new IllegalArgumentException("Debit card number is too short to mask.");
        }

        // Generate a masked card number with only the last 4 digits visible
        String maskedPart = "**** **** **** ";
        String lastFourDigits = sanitizedCardNumber.substring(length - 4);

        return maskedPart + lastFourDigits;
    }
    
}
