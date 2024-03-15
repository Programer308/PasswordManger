public class CaesarCipher extends PasswordEncryption {

    private static final int SHIFT = 3; // Shift value for the Caesar Cipher

    @Override
    public String encryptPassword(String password) {
        StringBuilder encryptedPassword = new StringBuilder();

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char shifted = (char) (((ch - 'A' + SHIFT) % 26) + 'A');
                encryptedPassword.append(shifted);
            } else if (Character.isLowerCase(ch)) {
                char shifted = (char) (((ch - 'a' + SHIFT) % 26) + 'a');
                encryptedPassword.append(shifted);
            } else {
                encryptedPassword.append(ch);
            }
        }

        return encryptedPassword.toString();
    }

    @Override
    public String decryptPassword(String encryptedPassword) {
        StringBuilder decryptedPassword = new StringBuilder();

        for (char ch : encryptedPassword.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char shifted = (char) (((ch - 'A' - SHIFT + 26) % 26) + 'A');
                decryptedPassword.append(shifted);
            } else if (Character.isLowerCase(ch)) {
                char shifted = (char) (((ch - 'a' - SHIFT + 26) % 26) + 'a');
                decryptedPassword.append(shifted);
            } else {
                decryptedPassword.append(ch);
            }
        }

        return decryptedPassword.toString();
    }
}