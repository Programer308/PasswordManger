public abstract class PasswordEncryption {

    public abstract String encryptPassword(String password);
    public abstract String decryptPassword(String encryptedPassword);

    public String ratePassword(String password) {
        int strengthPoints = 0;

        // Criteria 1: Length (>= 8 characters)
        if (password.length() >= 8) strengthPoints++;

        // Criteria 2: Upper and Lower case
        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*")) strengthPoints++;

        // Criteria 3: Includes number
        if (password.matches(".*[0-9].*")) strengthPoints++;

        // Criteria 4: Special character
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) strengthPoints++;

        // Additional length criteria for stronger passwords
        if (password.length() >= 12) strengthPoints += 2;
        if (password.length() >= 16) strengthPoints += 2;

        // Calculate the strength rating
        String strengthBar = "Password Strength: [";
        String rating;
        for (int i = 0; i < 8; i++) {
            if (i < strengthPoints) strengthBar += "■";
            else strengthBar += " ";
        }
        strengthBar += "]";

        // Assigning a textual rating based on strengthPoints
        if (strengthPoints <= 2) rating = "Very Weak";
        else if (strengthPoints <= 4) rating = "Weak";
        else if (strengthPoints <= 6) rating = "Good";
        else if (strengthPoints == 7) rating = "Strong";
        else rating = "Excellent";

        return strengthBar + " (" + rating + ")";
    }

    


    
}