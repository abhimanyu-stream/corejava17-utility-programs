package com.java17.utilityprograms;


public class WindowsLinuxUbuntuPathMapping {
    //Intellij IDEA Settings
    //File -> Settings -> Editor -> Inspections -> JVM Languages : Find serialization class without serialVersionUID and check it.
    // Back to the editor, clicks on the class name, ALT + ENTER (Windows), it will prompts the Add serialVersionUID field option.
    // A new serialVersionUID is auto-generated.
    public static void main(String[] args) {
        String[] paths = {
                "C:\\Users\\JohnDoe\\Documents\\file.txt",
                "Devlopment:\\Users\\JohnDoe\\Documents\\file.txt",
                "devlopment:\\Users\\JohnDoe\\Documents\\file.txt",
                "c:\\Users\\JohnDoe\\Documents\\file.txt"
        };

        for (String path : paths) {

            String linuxUbuntuPath = convertToLinuxPath(path);
            System.out.println(linuxUbuntuPath); // Output the Linux path
        }
    }

    public static String convertToLinuxPath(String path) {


        // Regex to remove the drive name (case insensitive)
        // Regex to match the username after "\\Users" and the backslash following it
        // Matches the username and the optional following backslash
        String regex = "(?<=\\\\Users\\\\)[^\\\\]*\\\\?";

        // Replace the matched username with an empty string
        String userNameRemovedFromPath = path.replaceAll(regex, "");
        System.out.println("path :  "+ userNameRemovedFromPath);
        //w = [a-zA-Z0-9_]
        String windowsToLinuxUbuntuRegex = "^[a-zA-Z0-9_-]*:\\\\";
        // Replace the drive name and convert backslashes to slashes
        String result = userNameRemovedFromPath.replaceAll(windowsToLinuxUbuntuRegex, "").replace("\\", "/").replace("Users", "/home/ubuntu");//ubuntu
        return result;
        //output:--
        //  path :  C:\Users\Documents\file.txt
        //  /home/ubuntu/Documents/file.txt
        //  path :  Devlopment:\Users\Documents\file.txt
        //  /home/ubuntu/Documents/file.txt
        //  path :  devlopment:\Users\Documents\file.txt
        //  /home/ubuntu/Documents/file.txt
        //  path :  c:\Users\Documents\file.txt
        //  /home/ubuntu/Documents/file.txt
    }
}
/***
 * the Java program snippet you've provided, particularly the regex and the subsequent string manipulations:
 *
 * Breakdown of the Code
 * Regex Declaration:
 *
 * java
 * Copy code
 * String regex = "^[a-zA-Z0-9_-]*:\\\\";
 * ^: Asserts the position at the start of the string.
 * [a-zA-Z0-9_-]: This character class matches:
 * Any uppercase letter (A-Z)
 * Any lowercase letter (a-z)
 * Any digit (0-9)
 * The underscore (_)
 * The hyphen (-)
 * *: This quantifier means "zero or more" occurrences of the preceding character class.
 * :: Matches a colon character literally.
 * \\\\: Matches a backslash (\). In Java, backslashes must be escaped, so \\\\ represents a single \.
 * Overall Meaning: This regex matches a drive name (which can consist of letters, digits, underscores, and hyphens) followed by a colon and then a backslash (e.g., C:\, D:\, my-drive:\).
 *
 * String Manipulation:
 *
 * java
 * Copy code
 * String result = path.replaceAll(regex, "").replace("\\", "/").replace("Users", "/home");
 * path.replaceAll(regex, ""):
 *
 * This uses the regex to find any drive name and the subsequent :\ in the path. It replaces this matched portion with an empty string, effectively removing it.
 * For example, converting C:\Users\JohnDoe\Documents\file.txt to Users\JohnDoe\Documents\file.txt.
 * .replace("\\", "/"):
 *
 * This converts all remaining backslashes (\) in the string to forward slashes (/). This is typical in converting Windows paths to a Unix-like format.
 * Continuing the example, it would convert Users\JohnDoe\Documents\file.txt to Users/JohnDoe/Documents/file.txt.
 * .replace("Users", "/home"):
 *
 * This replaces the substring Users with /home, which is a common practice in Unix/Linux environments to denote the home directory.
 * After this replacement, the path would now be /home/JohnDoe/Documents/file.txt.
 * Return Statement:
 *
 * java
 * Copy code
 * return result;
 * This returns the final modified path as the output of the method.
 * Summary
 * This program is effectively designed to:
 *
 * Remove the drive letter and its colon/backslash from a Windows file path.
 * Convert any remaining backslashes to forward slashes for Unix/Linux compatibility.
 * Replace the Users directory with /home, reflecting a common structure in Unix-like systems.
 * Example Input and Output
 * Input: "C:\\Users\\JohnDoe\\Documents\\file.txt"
 * Output: "/home/JohnDoe/Documents/file.txt"
 * This approach makes it easy to transform Windows-style file paths into Linux-style paths while adapting to typical directory structures.
 * */
