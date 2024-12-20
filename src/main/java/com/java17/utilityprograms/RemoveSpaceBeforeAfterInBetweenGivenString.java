package com.java17.utilityprograms;

public class RemoveSpaceBeforeAfterInBetweenGivenString {
    public static void main(String[] args) {
        String input = "  Hello   World   !  ";

        // Remove white spaces before and after the string using trim()
        String trimmedString = input.trim();

        // Remove all white spaces (including in between words)
        String noWhiteSpaceString = trimmedString.replaceAll("\\s+", "");

        System.out.println("Original String: \"" + input + "\"");
        System.out.println("String after removing spaces: \"" + noWhiteSpaceString + "\"");
    }
}
/**
 * trim() removes leading and trailing spaces.
 * replaceAll("\\s+", "") removes all spaces, including those in between words.
 * If you want to keep spaces between words but remove extra spaces, you can replace multiple spaces with a single space
 * like this: String singleSpaceString = trimmedString.replaceAll("\\s{2,}", " ");
 *
 *
 * */
