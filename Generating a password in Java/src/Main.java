import java.util.Random;

public class RandomPassword {
    public static void main(String[] args) {
        int length = 10; // default password length
        int complexity = 1; // default password complexity (1 - only lowercase letters, 2 - lowercase and uppercase letters, 3 - lowercase, uppercase and numbers)

        if (args.length > 0) {
            try {
                length = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
                System.exit(1);
            }
        }

        if (args.length > 1) {
            try {
                complexity = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[1] + " must be an integer.");
                System.exit(1);
            }
        }

        if (complexity < 1 || complexity > 3) {
            System.err.println("Complexity must be between 1 and 3.");
            System.exit(1);
        }

        System.out.println(generatePassword(length, complexity));
    }

    public static String generatePassword(int length, int complexity) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        if (complexity >= 2) {
            characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (complexity >= 3) {
            characters += "0123456789";
        }

        Random rng = new Random();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = characters.charAt(rng.nextInt(characters.length()));
        }

        return new String(password);
    }
}
