package mcfadden.scarlett.lab2;

public class SimpleStringManipulator {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: Invalid number of arguments. Please provide exactly two strings as arguments.");
            return;
        }

        String first = args[0];
        String second = args[1];

        if (first.isEmpty() || second.isEmpty()) {
            System.err.println("Error: Arguments must be non-empty strings.");
            return;
        }

        char firstChar = first.charAt(0);
        if (isVowel(firstChar)) {
            first = Character.toUpperCase(firstChar) + first.substring(1);
        } else {
            first = Character.toLowerCase(firstChar) + first.substring(1);
        }

        char lastChar = second.charAt(second.length() - 1);
        if (isConsonant(lastChar)) {
            second = second.substring(0, second.length() - 1) + Character.toUpperCase(lastChar);
        } else {
            second = second.substring(0, second.length() - 1) + Character.toLowerCase(lastChar);
        }

        String result = first + second;

        System.out.println("First String: " + args[0]);
        System.out.println("Second String: " + args[1]);
        System.out.println("Resulting String: " + result);
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static boolean isConsonant(char c) {
        return Character.isLetter(c) && !isVowel(c);
    }
}

