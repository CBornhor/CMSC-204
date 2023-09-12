import java.util.ArrayList;

public class PasswordCheckerUtility {

    public PasswordCheckerUtility() {
    }

    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!password.equals(passwordConfirm)) {
            throw new UnmatchedException("The passwords do not match");
        }
    }

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }

    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException("The password must be at least 6 characters long");
        }
        return true;
    }

    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        if (!password.chars().anyMatch(Character::isUpperCase)) {
            throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
        }
        return true;
    }

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        if (!password.chars().anyMatch(Character::isLowerCase)) {
            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
        }
        return true;
    }

    public static boolean hasDigit(String password) throws NoDigitException {
        if (!password.chars().anyMatch(Character::isDigit)) {
            throw new NoDigitException("The password must contain at least one digit");
        }
        return true;
    }

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
            throw new NoSpecialCharacterException("The password must contain at least one special character");
        }
        return true;
    }

    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
                throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
            }
        }
        return false;
    }

    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        isValidLength(password);
        hasUpperAlpha(password);
        hasLowerAlpha(password);
        hasDigit(password);
        hasSpecialChar(password);
        NoSameCharInSequence(password);
        return true;
    }

    public static boolean hasBetweenSixAndNineChars(String password) {
        return password.length() >= 6 && password.length() <= 9;
    }

    public static boolean isWeakPassword(String password) throws WeakPasswordException {
        if (hasBetweenSixAndNineChars(password)) {
            throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
        }
        return false;
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<>();
        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception e) {
                invalidPasswords.add(password + " " + e.getMessage());
            }
        }
        return invalidPasswords;
    }

}